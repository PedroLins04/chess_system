package ChessLayer;

import BoardLayer.Board;

public class Match {

    private Board board;

    //CONSTRUCTORS

    public Match (){
        board = new Board(8,8);
    }

    //METHODS

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0 ; i < board.getRows() ; i++) {
            for (int j = 0 ; j < board.getColumns() ; j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }
}
