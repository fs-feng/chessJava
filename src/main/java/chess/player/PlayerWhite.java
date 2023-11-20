package chess.player;

import chess.game.Move;
import chess.pieces.Color;

public class PlayerWhite extends Player{
    public PlayerWhite(Color color) {
        super(color);
    }

    @Override
    public Move getNextMove() {
        return null;
    }
}
