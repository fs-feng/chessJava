package chess.view;

import chess.board.Square;
import chess.game.GameHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareButton extends JButton {
    private Square square;
    private GameHandler gameHandler;
    private int col;
    private int row;

    public SquareButton(int row, int col, GameHandler gameHandler) {
        this.setPreferredSize(new Dimension(90,90));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.gameHandler = gameHandler;
        this.col = col;
        this.row = row;
        square = gameHandler.getBoard().getBoard()[row][col];


        initButtonColor(square.getRow(), square.getCol());
        initActionListener();
        displayPiece();

    }

    public void initActionListener() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameHandler.handleButtonClick(row, col);
            }
        });
    }

    public void initButtonColor(int row, int col) {
        if ((row % 2 == 1 && col % 2 == 1) || (row % 2 == 0 && col % 2 == 0))
            this.setBackground(Color.decode("#FAF0E6"));
        else
            this.setBackground(Color.decode("#800020"));

    }

    public void blueBorder() {
        this.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
    }

    public void removeBorder() {
        this.setBorder(null);
    }

    public void displayPiece() {
        if (square.getPiece() != null)
            this.setIcon(square.getPiece().getPieceIcon());
        else
            this.setIcon(null);
    }


    public Square getSquare() {
        return square;
    }
}
