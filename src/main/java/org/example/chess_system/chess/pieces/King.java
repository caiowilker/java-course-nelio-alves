package org.example.chess_system.chess.pieces;

import org.example.chess_system.boardgame.Board;
import org.example.chess_system.boardgame.Position;
import org.example.chess_system.chess.ChessPiece;
import org.example.chess_system.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position positon) {
        ChessPiece p = (ChessPiece)getBoard().piece(positon);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        p.setValues(p.getRow() - 1, p.getColunm());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        p.setValues(p.getRow() + 1, p.getColunm());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        p.setValues(p.getRow(), p.getColunm()  - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        p.setValues(p.getRow(), p.getColunm()  + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        p.setValues(p.getRow() - 1, p.getColunm()  - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        p.setValues(p.getRow() - 1, p.getColunm()  + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        p.setValues(p.getRow() + 1, p.getColunm()  - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        p.setValues(p.getRow() + 1, p.getColunm()  + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColunm()] = true;
        }

        return mat;
    }
}
