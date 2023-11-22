package chess.player;

import chess.board.Square;
import chess.game.Move;
import chess.pieces.Color;

public abstract class Player {
    private Square start;
    private Square end;
    private Color color;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract Move getNextMove();


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
}
