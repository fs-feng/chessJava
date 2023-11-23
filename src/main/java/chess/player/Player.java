package chess.player;

import chess.board.Square;
import chess.game.Move;
import chess.pieces.Color;
import chess.pieces.King;
import chess.pieces.Piece;

import java.util.List;

public abstract class Player {
    private List<Piece> pieces;
    private King king;
    private Square start;
    private Square end;
    private Color color;

    public Player(Color color) {
        this.color = color;
    }

    public abstract Move getNextMove();

    public void addKing() {
        for (Piece piece : pieces) {
            if (piece instanceof King) {
                king = (King) piece;
                break;
            }
        }
    }



    public Color getColor() {
        return color;
    }

    public void setStart(Square start) {
        this.start = start;
    }

    public void setEnd(Square end) {
        this.end = end;
    }

    public Square getStart() {
        return start;
    }

    public Square getEnd() {
        return end;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public King getKing() {
        return king;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
