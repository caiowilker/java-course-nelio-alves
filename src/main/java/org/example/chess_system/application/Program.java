package org.example.chess_system.application;

import org.example.chess_system.boardgame.Board;
import org.example.chess_system.chess.ChessException;
import org.example.chess_system.chess.ChessMatch;
import org.example.chess_system.chess.ChessPiece;
import org.example.chess_system.chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()) {
            try {
                UI.clarScreen();
                UI.printMath(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readCheesPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clarScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readCheesPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }

                if (chessMatch.getPromoted() != null) {
                    System.out.println("Enter piece for promotion (B/N/R/Q) ");
                    String type = sc.nextLine();
                    chessMatch.replacePromotedPiece(type);
                }
            }
            catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clarScreen();
        UI.printMath(chessMatch, captured);
    }
}
