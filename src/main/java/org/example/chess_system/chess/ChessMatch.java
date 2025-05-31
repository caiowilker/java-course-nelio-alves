package org.example.chess_system.chess;

import org.example.chess_system.boardgame.Board;
import org.example.chess_system.boardgame.Piece;
import org.example.chess_system.boardgame.Position;
import org.example.chess_system.chess.pieces.King;
import org.example.chess_system.chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetap();
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

    public void initialSetap() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new Rook(board, Color.WHITE), new Position(7, 4));
    }
}
