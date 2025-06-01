package org.example.chess_system.chess.pieces;

import org.example.chess_system.boardgame.Board;
import org.example.chess_system.boardgame.Position;
import org.example.chess_system.chess.ChessMatch;
import org.example.chess_system.chess.ChessPiece;
import org.example.chess_system.chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColunm());
            if (getBoard().positionExists(p) && !getBoard().thereIsApicie(p)) {
                mat[p.getRow()][p.getColunm()] = true;
            }

            p.setValues(position.getRow() - 2, position.getColunm());
            Position p2 = new Position(position.getRow() - 1, position.getColunm());
            if (getBoard().positionExists(p) && !getBoard().thereIsApicie(p) && getBoard().positionExists(p2) && !getBoard().thereIsApicie(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColunm()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColunm() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColunm()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColunm() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColunm()] = true;
            }

            if (position.getRow() == 3) {
                Position left = new Position(position.getRow(), position.getColunm() - 1 );
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[left.getRow() - 1][left.getColunm()] = true;
                }

                Position right = new Position(position.getRow(), position.getColunm() + 1 );
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[right.getRow() - 1][right.getColunm()] = true;
                }
            }

        }
        else {
            p.setValues(position.getRow() + 1, position.getColunm());
            if (getBoard().positionExists(p) && !getBoard().thereIsApicie(p)) {
                mat[p.getRow()][p.getColunm()] = true;
            }

            p.setValues(position.getRow() + 2, position.getColunm());
            Position p2 = new Position(position.getRow() + 1, position.getColunm());
            if (getBoard().positionExists(p) && !getBoard().thereIsApicie(p) && getBoard().positionExists(p2) && !getBoard().thereIsApicie(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColunm()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColunm() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColunm()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColunm() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColunm()] = true;
            }

            if (position.getRow() == 4) {
                Position left = new Position(position.getRow(), position.getColunm() - 1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[left.getRow() + 1][left.getColunm()] = true;
                }

                Position right = new Position(position.getRow(), position.getColunm() + 1);
                if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[right.getRow() + 1][right.getColunm()] = true;
                }
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
