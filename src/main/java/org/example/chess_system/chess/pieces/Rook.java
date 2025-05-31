package org.example.chess_system.chess.pieces;

import org.example.chess_system.boardgame.Board;
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
        return mat;
    }
}
