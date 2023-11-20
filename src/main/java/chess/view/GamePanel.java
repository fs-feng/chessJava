package chess.view;

import chess.game.GameHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private ToolbarPanel toolbarPanel;
    private BoardPanel boardPanel;

    public GamePanel(GameHandler gameHandler) {
        this.setLayout(new BorderLayout());

        boardPanel = new BoardPanel(gameHandler);
        toolbarPanel = new ToolbarPanel();

        this.add(toolbarPanel, BorderLayout.NORTH);
        this.add(boardPanel, BorderLayout.CENTER);
    }
}
