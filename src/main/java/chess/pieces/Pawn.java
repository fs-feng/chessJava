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

        int moveDirection = (getColor() == Color.white) ? -1 : 1;
        int row = getSquare().getRow() + moveDirection;
        int col = getSquare().getCol();

        if (0 <= row && row < 8 && 0 <= col && col < 8) {
            //forward
            if (board.getBoard()[row][col].getPiece() == null) {
                possibleMoves.add(new Move(getSquare(), board.getBoard()[row][col]));

                if (!isHasMoved() && board.getBoard()[row + moveDirection][col].getPiece() == null) {
                    possibleMoves.add(new Move(getSquare(), board.getBoard()[row + moveDirection][col]));
                }
            }

            //leftside
            if (getSquare().getCol() > 0 && board.getBoard()[row][col - 1].getPiece() != null && getColor() != board.getBoard()[row][col - 1].getPiece().getColor()) {
                possibleMoves.add(new Move(getSquare(), board.getBoard()[row][col - 1]));
            }



            //righht side
            if (getSquare().getCol() < 7 && board.getBoard()[row][col + 1].getPiece() != null && getColor() != board.getBoard()[row][col + 1].getPiece().getColor()) {
                possibleMoves.add(new Move(getSquare(), board.getBoard()[row][col + 1]));
            }
        }

        return possibleMoves;
    }


}
