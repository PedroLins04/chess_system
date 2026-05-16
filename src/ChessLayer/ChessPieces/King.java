package ChessLayer.ChessPieces;

import BoardLayer.Board;
import BoardLayer.Position;
import ChessLayer.ChessPiece;
import ChessLayer.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean mat[][] = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //ABOVE
        p.setValues(position.getRow() - 1, position.getColumn());
        if ((getBoard().positionExists(p)) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //BELOW
        p.setValues(position.getRow() + 1, position.getColumn());
        if ((getBoard().positionExists(p)) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //LEFT
        p.setValues(position.getRow(), position.getColumn() - 1);
        if ((getBoard().positionExists(p)) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //RIGHT
        p.setValues(position.getRow(), position.getColumn() + 1);
        if ((getBoard().positionExists(p)) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //NORTHWEST
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if ((getBoard().positionExists(p)) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //NORTHEAST
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if ((getBoard().positionExists(p)) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //SOUTHWEST
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if ((getBoard().positionExists(p)) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //SOUTHEAST
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if ((getBoard().positionExists(p)) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }


}
