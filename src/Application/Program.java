package Application;

import ChessLayer.ChessConsole.UI;
import ChessLayer.Match;

public class Program {
    public static void main(String[] args) {

        System.out.println();

        Match match = new Match();
        UI.printBoard(match.getPieces());

        System.out.println();
    }
}