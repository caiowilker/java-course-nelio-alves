package org.example.chess_system.chess.pieces;

import org.example.chess_system.boardgame.Board;
import org.example.chess_system.boardgame.Position;
import org.example.chess_system.chess.ChessPiece;
import org.example.chess_system.chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        p.setValues(position.getRow() - 1, position.getColunm());
        while (getBoard().positionExists(p) && !getBoard().thereIsApicie(p)) {
            mat[p.getRow()][p.getColunm()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExists(p)  && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        p.setValues(position.getRow(), position.getColunm() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsApicie(p)) {
            mat[p.getRow()][p.getColunm()] = true;
            p.setRow(p.getColunm() - 1);
        }
        if (getBoard().positionExists(p)  && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        p.setValues(position.getRow(), position.getColunm() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsApicie(p)) {
            mat[p.getRow()][p.getColunm()] = true;
            p.setRow(p.getColunm() + 1);
        }
        if (getBoard().positionExists(p)  && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        p.setValues(position.getRow() + 1, position.getColunm());
        while (getBoard().positionExists(p) && !getBoard().thereIsApicie(p)) {
            mat[p.getRow()][p.getColunm()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExists(p)  && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        return mat;
    }
}
