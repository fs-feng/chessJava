package chess.view;

import chess.game.GameHandler;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private SquareButton[][] board;
    private GridBagConstraints gbc;
    public BoardPanel(GameHandler gameHandler) {
        super(new GridBagLayout());
        gbc = new GridBagConstraints();

        createTopLabels();
        createSideLabels();
        initButtons(gameHandler);
    }


    public void initButtons(GameHandler gameHandler) {
        board = new SquareButton[8][8];
        gameHandler.setSquareButtons(board);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new SquareButton(row, col, gameHandler);
                gbc.gridx = col + 1;
                gbc.gridy = row + 1;
                this.add(board[row][col], gbc);

            }
        }
    }

    private void createTopLabels() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new JLabel(),gbc);
        for (int i = 0; i < 8; i++) {
            JLabel label = new JLabel(Character.toString((char) ('A' + i)), SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(90,30));
            label.setBackground(Color.BLACK);
            label.setForeground(Color.white);
            label.setOpaque(true);
            gbc.gridx = i + 1;
            gbc.gridy = 0;
            this.add(label, gbc);
        }
    }

    private void createSideLabels() {
        for (int i = 0; i < 8; i++) {
            JLabel label = new JLabel(Integer.toString(8 - i), SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(30,90));
            label.setBackground(Color.BLACK);
            label.setForeground(Color.white);
            label.setOpaque(true);
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            this.add(label, gbc);
        }
    }
}
