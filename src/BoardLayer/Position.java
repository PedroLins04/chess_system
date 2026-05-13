package BoardLayer;

import java.util.Objects;

public class Position {

    private int Row;
    private int Column;

    //CONSTRUCTORS

    public Position (){}

    public Position (int row, int column) {
        this.Row = row;
        this.Column = column;
    }

    //GETTERS AND SETTERS

    public int getRow() {
        return Row;
    }

    public void setRow(int row) {
        Row = row;
    }

    public int getColumn() {
        return Column;
    }

    public void setColumn(int column) {
        Column = column;
    }

    //HASH AND EQUALS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Row == position.Row && Column == position.Column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Row, Column);
    }

    //toString

    @Override
    public String toString() {
        return "Position{" +
                "Row=" + Row +
                ", Column=" + Column +
                '}';
    }
}
