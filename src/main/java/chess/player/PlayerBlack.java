package chess.player;

import chess.game.Move;
import chess.pieces.Color;

public class PlayerBlack extends Player{
    public PlayerBlack(Color color) {
        super(color);
    }

    @Override
    public Move getNextMove() {
        return new Move(getStart(), getEnd());
    }
}
