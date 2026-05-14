package ChessLayer;

import BoardLayer.Position;

public class ChessPosition {

    private char column;
    private int row;

    //CONSTRUCTOR

    public ChessPosition(char column, int row) {
        if (column < 0 || row < 0) {
            throw new ChessException("Error instantiating ChessPosition : Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    //GETTERS

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    //POSITION

    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
    }

    //toString

    @Override
    public String toString() {
        return "" + column + row;
    }

}
