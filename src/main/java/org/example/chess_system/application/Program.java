package org.example.chess_system.application;

import org.example.chess_system.boardgame.Board;
import org.example.chess_system.chess.ChessMatch;
import org.example.chess_system.chess.ChessPiece;
import org.example.chess_system.chess.ChessPosition;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readCheesPosition(sc);

            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UI.readCheesPosition(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            System.out.println();
        }
    }
}
