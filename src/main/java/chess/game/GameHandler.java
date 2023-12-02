package chess.game;

import chess.board.Board;
import chess.board.Square;
import chess.pieces.Color;
import chess.pieces.King;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.player.Player;
import chess.player.PlayerBlack;
import chess.player.PlayerWhite;
import chess.view.SquareButton;

import java.util.ArrayList;
import java.util.List;

public class GameHandler {
    private Board board;
    private SquareButton[][] squareButtons;
    private Player currentPlayer;
    private Player blackPlayer;
    private Player whitePlayer;
    private List<Move> moveHistory;

    public GameHandler() {
        board = new Board();
        whitePlayer = new PlayerWhite(Color.white, board.getWhitePieces());
        blackPlayer = new PlayerBlack(Color.black, board.getBlackPieces());
        currentPlayer = whitePlayer;
        moveHistory = new ArrayList<>();
    }

    public void handleButtonClick(Square clickedSquare) {

        // If no piece is currently selected
        if (currentPlayer.getStart() == null) {
            // If the clicked square contains a piece of the current player's color
            if (clickedSquare.getPiece() != null && clickedSquare.getPiece().getColor() == currentPlayer.getColor()) {
                if (!moveHistory.isEmpty()) {
                    clickedSquare.getPiece().setLastMove(moveHistory.getLast());
                }
                // Select this piece
                currentPlayer.setStart(clickedSquare);
                squareButtons[clickedSquare.getRow()][clickedSquare.getCol()].blueBorder();
                //show possible moves
                for (Move possibleMove : clickedSquare.getPiece().getPossiblesMoves(board)) {
                    int row = possibleMove.getEnd().getRow();
                    int col = possibleMove.getEnd().getCol();
                    squareButtons[row][col].highlightButton();
                }
            }
        } else {
            // If a piece is already selected
            currentPlayer.setEnd(clickedSquare);

            // Get the next move from the current player
            Move nextMove = currentPlayer.getNextMove();


            if (nextMove.getPieceMoved().moveValidator(nextMove, nextMove.getPieceMoved().getPossiblesMoves(board))) {
                applyMove(nextMove);
                switchPlayer();
                updateBoardView();
                System.out.println("valid move");
            } else {
                updateBoardView();
                System.out.println("invalid move");
            }

            nextMove = null;

            currentPlayer.setStart(null);
            currentPlayer.setEnd(null);
        }
    }


    public void switchPlayer() {
        if (currentPlayer.getColor() == Color.white)
            currentPlayer = blackPlayer;
        else
            currentPlayer = whitePlayer;
    }

    public void applyMove(Move move) {

        if (move.getEnd().getPiece() != null && move.getEnd().getPiece().isAlive()) {
            move.getPieceMoved().capture(move.getEnd().getPiece());
        }
        if (!move.getPieceMoved().isHasMoved()) {
            move.getPieceMoved().setHasMoved(true);
        }

        move.getStart().setPiece(null);
        move.getPieceMoved().setSquare(move.getEnd());
        move.getEnd().setPiece(move.getPieceMoved());
        moveHistory.add(move);
        isEnPassant();
        boolean isCheck = isKingCheck();
    }

    public void updateBoardView() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squareButtons[row][col].removeStyling();
                squareButtons[row][col].displayPiece();
            }
        }
    }

    public void isEnPassant() {
        Move lastMove = moveHistory.getLast();

        if (lastMove.isEnPassant()) {
            lastMove.getKilledPieceSquare().setPiece(null);

            lastMove.getPieceMoved().capture(lastMove.getKilledPieceSquare().getPiece());
        }
    }


    public boolean isKingCheck() {
        List<Piece> pieces = (currentPlayer.getColor() != Color.white) ? blackPlayer.getPieces() :  whitePlayer.getPieces();
        Square kingSquare = (currentPlayer.getColor() != Color.white) ? whitePlayer.getKing().getSquare() : blackPlayer.getKing().getSquare();
        List<Move> possibleMoves = new ArrayList<>();

        for (Piece piece : pieces) {
            for (Move possibleMove: piece.getPossiblesMoves(board)) {
                if (!possibleMoves.contains(possibleMove)) {
                    possibleMoves.add(possibleMove);
                }
            }
        }

        for (Move move : possibleMoves) {
            if (kingSquare.equals(move.getEnd())) {
                System.out.println("king is check");
                return true;
            }
        }

        return  false;
    }


    //getter and setter
    public Board getBoard() {
        return board;
    }

    public void setSquareButtons(SquareButton[][] squareButtons) {
        this.squareButtons = squareButtons;
    }
}
