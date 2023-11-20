package chess.pieces;

import chess.board.Board;
import chess.board.Square;

import javax.swing.*;
import java.awt.*;

public abstract class Piece {
    private Square currentSquare;
    private final PieceColor color;
    private final Icon pieceIcon;
    private boolean isAlive;

    public Piece(Square currentSquare, PieceColor color, String pieceName) {
        this.currentSquare = currentSquare;
        this.currentSquare.setPiece(this);
        this.color = color;
        isAlive = true;
        pieceIcon = setupIcon(pieceName);
    }

    private ImageIcon setupIcon(String pieceName) {
        Image pieceImage = new ImageIcon(this.getClass().getResource("/" + color + "_" + pieceName + ".png")).getImage();
        int newWidth = (int) (pieceImage.getWidth(null) * 1.5);
        int newHeight = (int) (pieceImage.getHeight(null) * 1.5);
        pieceImage = pieceImage.getScaledInstance(newWidth, newHeight, Image.SCALE_AREA_AVERAGING);

        return new ImageIcon(pieceImage);
    }

    //public abstract boolean moveValidator(Square targetSquare);

    public void move(Square destinationSquare) {
        currentSquare.setPiece(null);
        currentSquare = destinationSquare;
        currentSquare.setPiece(this);
    }

    public void move(Square destinationSquare, Piece killedPiece) {
        currentSquare.setPiece(null);
        currentSquare = destinationSquare;
        currentSquare.setPiece(this);

        killedPiece.setCurrentSquare(null);
        killedPiece.setAlive(false);
    }


    public void capture() {

    }


    public Icon getPieceIcon() {
        return pieceIcon;
    }

    public PieceColor getColor() {
        return color;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    public Square getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }
}
