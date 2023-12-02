package chess.game;

import chess.board.Square;
import chess.pieces.Piece;

import java.security.PublicKey;

public class Move {
    private Square start;
    private Square end;
    private Piece pieceMoved;
    private Square killedPieceSquare;
    private boolean isEnPassant;

    public Move(Square start, Square end) {
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
        isEnPassant = false;
        killedPieceSquare = null;
    }

    public Move(Square start, Square end, Square killedPieceSquare, boolean isEnPassant) {
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
        this.isEnPassant = isEnPassant;
        this.killedPieceSquare = killedPieceSquare;
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

    public boolean isEnPassant() {
        return isEnPassant;
    }

    public Square getKilledPieceSquare() {
        return killedPieceSquare;
    }
}
