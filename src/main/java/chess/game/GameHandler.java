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

    public void handleButtonClick(Square clickedSquare) {
        // Get the clicked square

        // If no piece is currently selected
        if (currentPlayer.getStart() == null) {
            // If the clicked square contains a piece of the current player's color
            if (clickedSquare.getPiece() != null && clickedSquare.getPiece().getColor() == currentPlayer.getColor()) {
                // Select this piece
                currentPlayer.setStart(clickedSquare);
            }
        } else {
            if (clickedSquare.getPiece() != null && clickedSquare.getPiece().getColor() == currentPlayer.getColor()) {
                currentPlayer.setStart(clickedSquare);
            } else {
                // If a piece is already selected
                currentPlayer.setEnd(clickedSquare);

                // Get the next move from the current player
                Move nextMove = currentPlayer.getNextMove();

                // If the next move is valid
                if (nextMove != null) {
                    // Apply the move to the game
                    applyMove(nextMove);
                    nextMove = null;
                    // Clear the selected squares
                    currentPlayer.setStart(null);
                    currentPlayer.setEnd(null);

                    // Switch the current player
                    switchPlayer();
                } else {
                    // If the next move is not valid, clear the selected squares
                    currentPlayer.setStart(null);
                    currentPlayer.setEnd(null);
                }
            }
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