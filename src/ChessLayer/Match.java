package ChessLayer;

import BoardLayer.Board;
import BoardLayer.Piece;
import BoardLayer.Position;
import ChessLayer.ChessPieces.*;

import java.util.ArrayList;
import java.util.List;

public class Match {

    private Board board;
    private int turn;
    private Color CurrentPlayer;

    private List<Piece> onBoard = new ArrayList<>();
    private List<Piece> captured = new ArrayList<>();

    //CONSTRUCTORS

    public Match() {
        board = new Board(8, 8);
        turn = 1;
        CurrentPlayer = Color.PURPLE;
        initialSetup();
    }

    //GETTERS

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return CurrentPlayer;
    }


    //METHODS

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
        if (CurrentPlayer != ((ChessPiece) board.piece(position)).getColor()) {
            throw new ChessException("You can't move the opponent pieces!!!");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves with this Piece");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to the target position!");
        }
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        if (capturedPiece != null) {
            onBoard.remove(capturedPiece);
            captured.add(capturedPiece);
        }
        return capturedPiece;
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        onBoard.add(piece);

    }

    public boolean[][] possibleMove(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    private void nextTurn() {
        turn++;
        if (CurrentPlayer == Color.PURPLE) {
            CurrentPlayer = Color.GREEN;
        } else {
            CurrentPlayer = Color.PURPLE;
        }
    }

    private void initialSetup() {

        //PURPLE
        placeNewPiece('a', 1, new Rook(board, Color.PURPLE));
        placeNewPiece('b', 1, new Knight(board, Color.PURPLE));
        placeNewPiece('c', 1, new Bishop(board, Color.PURPLE));
        placeNewPiece('d', 1, new Queen(board, Color.PURPLE));
        placeNewPiece('e', 1, new King(board, Color.PURPLE));
        placeNewPiece('f', 1, new Bishop(board, Color.PURPLE));
        placeNewPiece('g', 1, new Knight(board, Color.PURPLE));
        placeNewPiece('h', 1, new Rook(board, Color.PURPLE));
        placeNewPiece('a', 2, new Pawn(board, Color.PURPLE));
        placeNewPiece('b', 2, new Pawn(board, Color.PURPLE));
        placeNewPiece('c', 2, new Pawn(board, Color.PURPLE));
        placeNewPiece('d', 2, new Pawn(board, Color.PURPLE));
        placeNewPiece('e', 2, new Pawn(board, Color.PURPLE));
        placeNewPiece('f', 2, new Pawn(board, Color.PURPLE));
        placeNewPiece('g', 2, new Pawn(board, Color.PURPLE));
        placeNewPiece('h', 2, new Pawn(board, Color.PURPLE));

        //GREEN
        placeNewPiece('a', 8, new Rook(board, Color.GREEN));
        placeNewPiece('b', 8, new Knight(board, Color.GREEN));
        placeNewPiece('c', 8, new Bishop(board, Color.GREEN));
        placeNewPiece('d', 8, new Queen(board, Color.GREEN));
        placeNewPiece('e', 8, new King(board, Color.GREEN));
        placeNewPiece('f', 8, new Bishop(board, Color.GREEN));
        placeNewPiece('g', 8, new Knight(board, Color.GREEN));
        placeNewPiece('h', 8, new Rook(board, Color.GREEN));
        placeNewPiece('a', 7, new Pawn(board, Color.GREEN));
        placeNewPiece('b', 7, new Pawn(board, Color.GREEN));
        placeNewPiece('c', 7, new Pawn(board, Color.GREEN));
        placeNewPiece('d', 7, new Pawn(board, Color.GREEN));
        placeNewPiece('e', 7, new Pawn(board, Color.GREEN));
        placeNewPiece('f', 7, new Pawn(board, Color.GREEN));
        placeNewPiece('g', 7, new Pawn(board, Color.GREEN));
        placeNewPiece('h', 7, new Pawn(board, Color.GREEN));
    }
}
