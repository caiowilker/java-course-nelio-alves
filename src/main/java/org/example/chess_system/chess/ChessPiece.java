package org.example.chess_system.chess;

import org.example.chess_system.boardgame.Board;
import org.example.chess_system.boardgame.Piece;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
