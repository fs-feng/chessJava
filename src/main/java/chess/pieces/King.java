package chess.pieces;

import chess.board.Board;
import chess.board.Square;
import chess.game.Move;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(Square currentSquare, Color color, String pieceName) {
        super(currentSquare, color, pieceName);
    }

    @Override
    public List<Move> getPossiblesMoves(Board board) {
        List<Move> possibleMoves = new ArrayList<>();

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] direction : directions) {
            int row = getSquare().getRow() + direction[0];
            int col = getSquare().getCol() + direction[1];

            if (0 <= row && row < 8 && 0 <= col && col < 8) {
                if (board.getBoard()[row][col].getPiece() == null || getColor() != board.getBoard()[row][col].getPiece().getColor()) {
                    possibleMoves.add(new Move(getSquare(), board.getBoard()[row][col]));
                }
            }
        }

        return possibleMoves;
    }
}
