package chess.view;

import chess.game.GameHandler;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;


    public GameFrame(GameHandler gameHandler) {
        gamePanel = new GamePanel(gameHandler);
        this.add(gamePanel, BorderLayout.CENTER);

        try {
            initIcon();
        } catch (Exception e) {
            System.out.println(e);
        }
        this.setTitle("Chess");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void initIcon() throws MalformedURLException {
        Image icon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
        this.setIconImage(icon);
    }
}
