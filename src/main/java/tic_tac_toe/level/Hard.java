package tic_tac_toe.level;

import lombok.Data;
import tic_tac_toe.game.Cell;
import tic_tac_toe.game.GameValidator;

import java.util.List;

@Data
public class Hard implements GameLevel {

    private Cell aiMove;

    @Override
    public void aiMove(char[][] board, char human, char ai, int depth, char turn, GameValidator gameValidator) {
        minimax(board, human, ai, depth, turn, gameValidator);

        try {
            gameValidator.placeAMove(board, aiMove, ai);
        } catch (IllegalArgumentException ignore) {

        }
    }

    private int minimax(char[][] board, char human, char ai, int depth, char turn, GameValidator gameValidator) {
        if (gameValidator.hasPlayerWon(ai, board)) return 1;
        if (gameValidator.hasPlayerWon(human, board)) return -1;

        List<Cell> availableCells = gameValidator.getAvailableCells(board);

        if (availableCells.isEmpty()) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < availableCells.size(); i++) {
            Cell cell = availableCells.get(i);

            if (turn == ai) {
                gameValidator.placeAMove(board, cell, ai);
                int score = minimax(board, human, ai, depth + 1, human, gameValidator);
                max = Math.max(score, max);

                if (score >= 0 && depth == 0) {
                    aiMove = cell;
                }

                if (score == 1) {
                    board[cell.getX()][cell.getY()] = ' ';
                    break;
                }

                if ((i == availableCells.size() - 1 && max < 0) && depth == 0) {
                    aiMove = cell;
                }

            } else if (turn == human) {
                gameValidator.placeAMove(board, cell, human);
                int score = minimax(board, human, ai, depth + 1, ai, gameValidator);
                min = Math.min(score, min);

                if (min == -1) {
                    board[cell.getX()][cell.getY()] = ' ';
                    break;
                }
            }

            board[cell.getX()][cell.getY()] = ' ';
        }

        return turn == ai ? max : min;
    }

}
