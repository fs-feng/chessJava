package chess.pieces;

import chess.board.Board;
import chess.board.Square;
import chess.game.Move;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(Square currentSquare, Color color, String pieceName) {
        super(currentSquare, color, pieceName);
    }

    @Override
    public List<Move> getPossiblesMoves(Board board) {
        List<Move> possibleMoves = new ArrayList<>();
        if (getColor() == Color.white) {
            whitePossibleMoves();
        } else if (getColor() == Color.black) {
            blackPossibleMoves();
        }


        return null;
    }

    private void blackPossibleMoves() {

    }

    private void whitePossibleMoves() {
    }


}
