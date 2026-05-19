package ChessLayer;

import BoardLayer.Board;
import BoardLayer.Piece;
import BoardLayer.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    //CONSTRUCTOR

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    //GETTERS

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }


    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    //METHODS

    protected boolean isThereAnyOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

    protected void increaseMoveCount () {
        moveCount++;
    }

    protected void decreaseMoveCount() {
        moveCount--;
    }

}
