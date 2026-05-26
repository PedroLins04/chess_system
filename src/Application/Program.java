package Application;

import BoardLayer.Exception.BoardException;
import ChessLayer.ChessConsole.UI;
import ChessLayer.ChessException;
import ChessLayer.ChessPiece;
import ChessLayer.ChessPosition;
import ChessLayer.Match;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println();

        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_YELLOW = "\u001B[33m";
        Match match = new Match();
        List<ChessPiece> captured = new ArrayList<>();

        while (!match.getCheckMate()) {
            try {

                UI.clearScreen();
                UI.printMatch(match, captured);

                System.out.println();
                System.out.print(ANSI_CYAN + "Source: ");
                ChessPosition source = UI.ReadChessPosition(sc);

                boolean[][] possibleMoves = match.possibleMove(source);
                UI.clearScreen();
                UI.printBoard(match.getPieces(), possibleMoves);

                System.out.println();
                System.out.print(ANSI_CYAN + "Target: ");
                ChessPosition target = UI.ReadChessPosition(sc);

                ChessPiece capturedPiece = match.performChessMove(source, target);
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }

                if (match.getPromoted() != null) {
                    System.out.println(ANSI_YELLOW + "Enter the type for promotion! {Q/R/N/B}");
                    String type = sc.nextLine().toUpperCase();
                    while (!type.equals("Q") && !type.equals("R") && !type.equals("N") && !type.equals("B")) {
                        System.out.println(ANSI_YELLOW + "Invalid Value. Enter the type for promotion! {Q/R/N/B}");
                        type = sc.nextLine().toUpperCase();
                    }
                    match.replacePromotedPiece(type);
                }

            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (BoardException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(match, captured);

    }
}