package org.example.chess_system.chess;

import org.example.chess_system.boardgame.Board;
import org.example.chess_system.boardgame.Piece;
import org.example.chess_system.boardgame.Position;
import org.example.chess_system.chess.pieces.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMatch {
    private  int turn;
    private Color currentPlayer;
    private Board board;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerable;
    private ChessPiece promoted;


    private List<Piece> piecesOnTheBoad = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetap();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean getCheck() {
        return check;
    }

    public boolean getCheckMate() {
        return checkMate;
    }

    public ChessPiece getEnPassantVulnerable() {
        return enPassantVulnerable;
    }

    public ChessPiece getPromoted() {
        return promoted;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }
    
    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);

        if (testCheck(currentPlayer)) {
            undoMove(source, target, capturedPiece);
            throw new ChessException("You can´t put yourself in check");
        }

        ChessPiece movedPiece = (ChessPiece)board.piece(target);

        promoted = null;
        if (movedPiece instanceof Pawn) {
            if (movedPiece.getColor() == Color.WHITE && target.getRow() == 0 || movedPiece.getColor() == Color.BLACK && target.getRow() == 7) {
                promoted = (ChessPiece)board.piece(target);
                promoted = replacePromotedPiece("Q");
            }
        }

        check = (testCheck(opponent(currentPlayer)) ? true : false);

        if (testCheckMate(opponent(currentPlayer))) {
            checkMate = true;
        }
        else {
            nextTurn();
        }

        if (movedPiece instanceof Pawn && (target.getRow() == source.getRow() - 2 || target.getRow() == source.getRow() + 2)) {
            enPassantVulnerable = movedPiece;
        }
        else {
            enPassantVulnerable = null;
        }

        return  (ChessPiece)capturedPiece;
    }

    public ChessPiece replacePromotedPiece(String type) {
        if (promoted == null) {
            throw new IllegalStateException("There is no piece to be promoted");
        }
        if (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
            throw new InvalidParameterException("Invalid type for promotion");
        }

        Position pos = promoted.getChessPosition().toPosition();
        Piece p = board.removePiece(pos);
        piecesOnTheBoad.remove(p);

        ChessPiece newPiece = newPiece(type, promoted.getColor());
        board.placePiece(newPiece, pos);
        piecesOnTheBoad.add(newPiece);

        return newPiece;
    }

    private ChessPiece newPiece(String type, Color color) {
        if (type.equals("B")) return new Bishop(board, color);
        if (type.equals("N")) return new Knigth(board, color);
        if (type.equals("Q")) return new Queen(board, color);
        return new Rook(board, color);
    }

    private Piece makeMove(Position source, Position target) {
        ChessPiece p = (ChessPiece) board.removePiece(source);
        p.increaseMoveCount();
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        if (capturedPiece != null) {
            piecesOnTheBoad.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }

        if (p instanceof King && target.getColunm() == source.getColunm() + 2) {
            Position sorceT = new Position(source.getRow(), source.getColunm() + 3);
            Position targetT = new Position(source.getRow(), source.getColunm() + 1);
            ChessPiece rook = (ChessPiece)board.removePiece(sorceT);
            board.placePiece(rook, targetT);
            rook.increaseMoveCount();
        }

        if (p instanceof King && target.getColunm() == source.getColunm() - 2) {
            Position sorceT = new Position(source.getRow(), source.getColunm() - 4);
            Position targetT = new Position(source.getRow(), source.getColunm() - 1);
            ChessPiece rook = (ChessPiece)board.removePiece(sorceT);
            board.placePiece(rook, targetT);
            rook.increaseMoveCount();
        }

        if (p instanceof Pawn) {
            if (source.getColunm() != target.getColunm() && capturedPiece == null) {
                Position pawnPosition;
                if (p.getColor() == Color.WHITE) {
                    pawnPosition = new Position(target.getRow() + 1, target.getColunm());
                }
                else {
                    pawnPosition = new Position(target.getRow() - 1, target.getColunm());
                }
                capturedPiece = board.removePiece(pawnPosition);
                capturedPieces.add(capturedPiece);
                piecesOnTheBoad.remove(capturedPiece);
            }
        }
        return capturedPiece;
    }

    private void undoMove(Position source, Position target, Piece capturedPiece) {
        ChessPiece p = (ChessPiece) board.removePiece(target);
        p.decreaseMoveCount();
        board.placePiece(p, source);

        if (capturedPiece != null) {
            board.placePiece(capturedPiece, source);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoad.add(capturedPiece);
        }

        if (p instanceof King && target.getColunm() == source.getColunm() + 2) {
            Position sorceT = new Position(source.getRow(), source.getColunm() + 3);
            Position targetT = new Position(source.getRow(), source.getColunm() + 1);
            ChessPiece rook = (ChessPiece)board.removePiece(targetT);
            board.placePiece(rook, sorceT);
            rook.decreaseMoveCount();
        }

        if (p instanceof King && target.getColunm() == source.getColunm() - 2) {
            Position sorceT = new Position(source.getRow(), source.getColunm() - 4);
            Position targetT = new Position(source.getRow(), source.getColunm() - 1);
            ChessPiece rook = (ChessPiece)board.removePiece(targetT);
            board.placePiece(rook, sorceT);
            rook.decreaseMoveCount();
        }

        if (p instanceof Pawn) {
            if (source.getColunm() != target.getColunm() && capturedPiece == enPassantVulnerable) {
                ChessPiece pawn = (ChessPiece) board.removePiece(target);
                Position pawnPosition;
                if (p.getColor() == Color.WHITE) {
                    pawnPosition = new Position(3, target.getColunm());
                } else {
                    pawnPosition = new Position(4, target.getColunm());
                }
                board.placePiece(pawn,pawnPosition);
            }
        }
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsApicie(position)) {
            throw new ChessException("There is no piece on source position");
        }
        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
            throw new ChessException("The chosen piece is not yours");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is not possible moves for the chosen piece");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can`t move to target position");
        }
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private Color opponent(Color color) {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece King(Color color) {
        List<Piece> list = piecesOnTheBoad.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
        for (Piece p : list) {
            if (p instanceof King) {
                return (ChessPiece) p;
            }
        }
        throw new IllegalStateException("There is no " + color + "King on the board");
    }

    private boolean testCheck(Color color) {
        Position kingPosition = King(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnTheBoad.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
        for (Piece p : opponentPieces) {
            boolean[][] mat = p.possibleMoves();
            if (mat[kingPosition.getRow()][kingPosition.getColunm()]) {
                return true;
            }
        }
        return false;
    }

    private boolean testCheckMate(Color color) {
        if (!testCheck(color)) {
            return false;
        }
        List<Piece> list = piecesOnTheBoad.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
        for (Piece p : list) {
            boolean[][] mat = p.possibleMoves();
            for (int i = 0; i < board.getRows(); i++) {
                for (int j = 0; j < board.getColumns(); j++) {
                    if (mat[i][j]) {
                        Position source = ((ChessPiece)p).getChessPosition().toPosition();
                        Position target = new Position(i, j);
                        Piece capturedPiece = makeMove(source, target);
                        boolean testCheck = testCheck(color);
                        undoMove(source, target,capturedPiece);
                        if (!testCheck) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoad.add(piece);
    }

    public void initialSetap() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE, this));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK, this));
    }
}
