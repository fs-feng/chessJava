package chess.board;

import chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Square[][] board;
    private List<Piece> whitePieces;
    private List<Piece> blackPieces;

    public Board() {
        initBoard();
        initPieces();
    }


    public void initBoard() {
        board = new Square[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Square(row, col);
            }
        }
    }

    public void initPieces() {
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();

        whitePieces.add(new Rook(board[7][0], Color.white, "rook"));
        whitePieces.add(new Knight(board[7][1], Color.white, "knight"));
        whitePieces.add(new Bishop(board[7][2], Color.white, "bishop"));
        whitePieces.add(new Queen(board[7][3], Color.white, "queen"));
        whitePieces.add(new King(board[7][4], Color.white, "king"));
        whitePieces.add(new Bishop(board[7][5], Color.white, "bishop"));
        whitePieces.add(new Knight(board[7][6], Color.white, "knight"));
        whitePieces.add(new Rook(board[7][7], Color.white, "rook"));
        for (int i = 0; i < 8; i++) {
            whitePieces.add(new Pawn(board[6][i], Color.white, "pawn"));
        }

        blackPieces.add(new Rook(board[0][0], Color.black, "rook"));
        blackPieces.add(new Knight(board[0][1], Color.black, "knight"));
        blackPieces.add(new Bishop(board[0][2], Color.black, "bishop"));
        blackPieces.add(new King(board[0][3], Color.black, "king"));
        blackPieces.add(new Queen(board[0][4], Color.black, "queen"));
        blackPieces.add(new Bishop(board[0][5], Color.black, "bishop"));
        blackPieces.add(new Knight(board[0][6], Color.black, "knight"));
        blackPieces.add(new Rook(board[0][7], Color.black, "rook"));

        for (int i = 0; i < 8; i++) {
            blackPieces.add(new Pawn(board[1][i], Color.black, "pawn"));
        }
    }


    public Square[][] getBoard() {
        return board;
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }
}
