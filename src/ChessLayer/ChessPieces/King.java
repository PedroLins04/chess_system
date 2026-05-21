package ChessLayer.ChessPieces;

import BoardLayer.Board;
import BoardLayer.Position;
import ChessLayer.ChessPiece;
import ChessLayer.Color;
import ChessLayer.Match;

public class King extends ChessPiece {

    private Match match;

    public King(Board board, Color color, Match match) {
        super(board, color);
        this.match = match;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testCastling(Position position) {
        ChessPiece p = ((ChessPiece) getBoard().piece(position));
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;

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

        //SPECIAL MOVE

        if (getMoveCount() == 0 && !match.getCheck()) {
            Position Pos1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testCastling(Pos1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            Position Pos2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testCastling(Pos2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }


}
