package chess.game;

import chess.board.Square;
import chess.pieces.Piece;

public class Move {
    private Square start;
    private Square end;
    private Piece pieceMoved;

    public Move(Square start, Square end) {
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public Square getStart() {
        return start;
    }

    public Square getEnd() {
        return end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }
}