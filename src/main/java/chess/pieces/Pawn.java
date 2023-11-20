package chess.pieces;

import chess.board.Board;
import chess.board.Square;

public class Pawn extends Piece {
    public Pawn(Square currentSquare, PieceColor color, String pieceName) {
        super(currentSquare, color, pieceName);
    }


    public boolean moveValidator(Square targetSquare) {
        int currentRow = getCurrentSquare().getRow();
        int currentCol = getCurrentSquare().getCol();
        int targetRow = targetSquare.getRow();
        int targetCol = targetSquare.getCol();

        if (targetRow - 1 == currentRow && targetCol == currentCol)
            return true;

        return false;
    }


}
