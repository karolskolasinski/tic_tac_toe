package tic_tac_toe.game;

import java.util.ArrayList;
import java.util.List;

public class GameValidator {

    private char[][] board;
    private char human;
    private char ai;

    GameValidator(char[][] board, char human, char ai) {
        this.board = board;
        this.human = human;
        this.ai = ai;
    }

    /**
     *
     */
    private boolean placeAMove(Cell cell, char player) {
        if (board[cell.getX()][cell.getY()] != Character.MIN_VALUE) {
            return false;
        }

        board[cell.getX()][cell.getY()] = player;
        return true;
    }

    /**
     *
     */
    boolean isGameOver() {
        return hasPlayerWon(human) || hasPlayerWon(ai) || getAvailableCells().isEmpty();
    }

    /**
     *
     */
    private boolean hasPlayerWon(char player) {
        //diagonal
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == player ||
                board[0][2] == board[1][1] && board[0][0] == board[2][0] && board[0][0] == player) {
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
     *
     */
    private List<Cell> getAvailableCells() {
        List<Cell> availableCells = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Character.MIN_VALUE) {
                    availableCells.add(new Cell(i, j));
                }
            }
        }

        return availableCells;
    }
}
