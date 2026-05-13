package BoardLayer;

public class Piece {

    protected Position position;
    private Board board;

    //CONSTRUCTOR

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    //GETTER - Board

    protected Board getBoard() {
        return board;
    }
}
