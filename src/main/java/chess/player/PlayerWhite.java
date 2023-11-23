package chess.player;

import chess.board.Square;
import chess.game.Move;
import chess.pieces.Color;
import chess.pieces.Piece;

import java.util.List;

public class PlayerWhite extends Player{



    public PlayerWhite(Color color, List<Piece> pieces) {
        super(color);
        setPieces(pieces);
        addKing();
    }

    @Override
    public Move getNextMove() {
        return new Move(getStart(), getEnd());
    }



}
