package tic_tac_toe.game;

import java.util.ArrayList;
import java.util.List;

public class GameValidator {

    /**
     *
     */
    public void placeAMove(char[][] board, Cell cell, char player) {
        if (board[cell.getX()][cell.getY()] != ' ') {
            throw new IllegalArgumentException("This field is already taken!");
        }

        board[cell.getX()][cell.getY()] = player;
    }

    /**
     *
     */
    boolean isGameOver(char[][] board, char human, char ai) {
        return hasPlayerWon(human, board) || hasPlayerWon(ai, board) || getAvailableCells(board).isEmpty();
    }

    /**
     *
     */
    public boolean hasPlayerWon(char player, char[][] board) {
        //diagonal
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == player ||
                board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == player) {
            return true;
        }

        //horizontal + vertical
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == player ||
                    board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == player) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param board
     */
    public List<Cell> getAvailableCells(char[][] board) {
        List<Cell> availableCells = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    availableCells.add(new Cell(i, j));
                }
            }
        }

        return availableCells;
    }
}
