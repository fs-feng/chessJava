package chess.game;

import chess.board.Board;
import chess.board.Square;
import chess.pieces.Color;
import chess.pieces.Piece;
import chess.player.Player;
import chess.player.PlayerBlack;
import chess.player.PlayerWhite;
import chess.view.SquareButton;

public class GameHandler {
    private Board board;
    private SquareButton[][] squareButtons;
    private SquareButton selectedButton;
    private Player currentPlayer;
    private Player blackPlayer;
    private Player whitePlayer;

    public GameHandler() {
        board = new Board();
        whitePlayer = new PlayerWhite(Color.white);
        blackPlayer = new PlayerBlack(Color.black);
        currentPlayer = whitePlayer;
        selectedButton = null;

    }

    public void handleButtonClick(int row, int col) {
        SquareButton button = squareButtons[row][col];
        if (selectedButton == null && button.getSquare().getPiece() != null) {
            if (currentPlayer.getColor() == button.getSquare().getPiece().getColor()) {
                selectedButton = button;
                selectedButton.blueBorder();
            }
        } else if (button.getSquare().getPiece() != null) {
            if (currentPlayer.getColor() == button.getSquare().getPiece().getColor()) {
                selectedButton.removeBorder();
                selectedButton = squareButtons[row][col];
                selectedButton.blueBorder();
            } else if (button.getSquare().getPiece().getColor() != currentPlayer.getColor() && selectedButton.getSquare().getPiece() != null){
                Move move = new Move(selectedButton.getSquare(), button.getSquare());
                squareButtons[row][col].getSquare().getPiece().setAlive(false);
                applyMove(move);
                switchPlayer();
            }
        } else if (selectedButton != null){
            Move move = new Move(selectedButton.getSquare(), squareButtons[row][col].getSquare());
            applyMove(move);
            switchPlayer();
        }
    }

    public void switchPlayer() {
        if (currentPlayer.getColor() == Color.white)
            currentPlayer = blackPlayer;
        else
            currentPlayer = whitePlayer;
    }

    public void applyMove(Move move) {
        move.getStart().setPiece(null);
        move.getEnd().setPiece(move.getPieceMoved());
        updateBoardView();
    }

    public void updateBoardView() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squareButtons[row][col].removeBorder();
                squareButtons[row][col].displayPiece();
            }
        }
    }



    //getter and setter
    public Board getBoard() {
        return board;
    }

    public void setSquareButtons(SquareButton[][] squareButtons) {
        this.squareButtons = squareButtons;
    }
}
