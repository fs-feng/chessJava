package chess.pieces;

import chess.board.Board;
import chess.board.Square;
import chess.game.Move;
import chess.view.SquareButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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


    public abstract List<Move> getPossiblesMoves(Board board);

    public boolean moveValidator(Move move, List<Move> possibleMoves) {
        for (Move possibleMove : possibleMoves) {
            if (move.equals(possibleMove)) {

                return true;
            }
        }

        return false;
    }


    public void move(Square destinationSquare, Piece killedPiece) {
        square.setPiece(null);
        square = destinationSquare;
        square.setPiece(this);

        killedPiece.setSquare(null);
        killedPiece.setAlive(false);
    }


    public void capture(Piece piece) {
        piece.setAlive(false);
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

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
}
