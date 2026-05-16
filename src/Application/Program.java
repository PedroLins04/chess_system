package Application;

import BoardLayer.Exception.BoardException;
import ChessLayer.ChessConsole.UI;
import ChessLayer.ChessException;
import ChessLayer.ChessPiece;
import ChessLayer.ChessPosition;
import ChessLayer.Match;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println();

        Match match = new Match();

        while (true) {
            try {

                UI.clearScreen();
                UI.printMatch(match);

                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.ReadChessPosition(sc);

                boolean[][] possibleMoves = match.possibleMove(source);
                UI.clearScreen();
                UI.printBoard(match.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.ReadChessPosition(sc);

                ChessPiece capturedPiece = match.performChessMove(source, target);
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

    }
}