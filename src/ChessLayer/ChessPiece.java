package ChessLayer;

import BoardLayer.Board;
import BoardLayer.Piece;
import BoardLayer.Position;

public abstract class ChessPiece extends Piece {

    private Color color;

    //CONSTRUCTOR

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    //GETTER - color

    public Color getColor() {
        return color;
    }

    //METHODS

    protected boolean isThereAnyOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

}
