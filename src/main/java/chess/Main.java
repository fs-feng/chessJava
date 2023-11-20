package chess;

import chess.game.GameHandler;
import chess.view.GameFrame;

public class Main {
    public static void main(String[] args) {
        GameHandler gameHandler = new GameHandler();
        GameFrame gameFrame = new GameFrame(gameHandler);
    }
}