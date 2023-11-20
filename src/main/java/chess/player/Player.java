package chess.player;

import chess.game.Move;
import chess.pieces.Color;

public abstract class Player {
    private Color color;

    public Player(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract Move getNextMove();

}
