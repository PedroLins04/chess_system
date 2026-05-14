package Application;

import ChessLayer.ChessConsole.UI;
import ChessLayer.ChessPiece;
import ChessLayer.ChessPosition;
import ChessLayer.Match;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println();

        Match match = new Match();

        while (true) {
            UI.printBoard(match.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.ReadChessPosition(sc);

            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UI.ReadChessPosition(sc);

            ChessPiece capturedPiece = match.performChessMove(source, target);
        }

    }
}