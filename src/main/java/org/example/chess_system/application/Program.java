package org.example.chess_system.application;

import org.example.chess_system.boardgame.Board;
import org.example.chess_system.chess.ChessMatch;

public class Program {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
