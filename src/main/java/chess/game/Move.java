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


    //no idea how this works will look later
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Move move = (Move) obj;
        return start == move.start &&
                end == move.end &&
                pieceMoved == move.pieceMoved;
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
