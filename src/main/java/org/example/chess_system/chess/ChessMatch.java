package org.example.chess_system.chess;

import org.example.chess_system.boardgame.Board;
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

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    public void initialSetap() {
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
    }
}
