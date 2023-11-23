package chess.player;

import chess.game.Move;
import chess.pieces.Color;
import chess.pieces.Piece;

import java.util.List;

public class PlayerBlack extends Player{
    public PlayerBlack(Color color, List<Piece> pieces) {
        super(color);
        setPieces(pieces);
        addKing();
    }

    @Override
    public Move getNextMove() {
        return new Move(getStart(), getEnd());
    }
}
