package chess.pieces;

import chess.board.Square;
import chess.view.SquareButton;

import javax.swing.*;
import java.awt.*;

public abstract class Piece {
    private Square square;
    private final Color color;
    private final Icon pieceIcon;
    private boolean isAlive;
    private boolean hasMoved;

    public Piece(Square currentSquare, Color color, String pieceName) {
        this.square = currentSquare;
        this.square.setPiece(this);
        this.color = color;
        isAlive = true;
        pieceIcon = setupIcon(pieceName);
        hasMoved = false;
    }

    private ImageIcon setupIcon(String pieceName) {
        Image pieceImage = new ImageIcon(this.getClass().getResource("/" + color + "_" + pieceName + ".png")).getImage();
        int newWidth = (int) (pieceImage.getWidth(null) * 1.5);
        int newHeight = (int) (pieceImage.getHeight(null) * 1.5);
        pieceImage = pieceImage.getScaledInstance(newWidth, newHeight, Image.SCALE_AREA_AVERAGING);

        return new ImageIcon(pieceImage);
    }

    //public abstract boolean moveValidator(Move move);

    public void move(Square destinationSquare) {
        square.setPiece(null);
        square = destinationSquare;
        square.setPiece(this);
    }

    public void move(Square destinationSquare, Piece killedPiece) {
        square.setPiece(null);
        square = destinationSquare;
        square.setPiece(this);

        killedPiece.setSquare(null);
        killedPiece.setAlive(false);
    }


    public void capture() {

    }


    public Icon getPieceIcon() {
        return pieceIcon;
    }

    public Color getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
}
