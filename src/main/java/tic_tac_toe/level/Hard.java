package tic_tac_toe.level;

import tic_tac_toe.game.Cell;
import tic_tac_toe.game.GameValidator;

import java.util.List;

public class Hard implements GameLevel {

    @Override
    public int aiMove(char[][] board, char human, char ai, int depth, char turn, Cell aiMove, GameValidator gameValidator) {
        if (gameValidator.hasPlayerWon(human, board)) return 1;
        if (gameValidator.hasPlayerWon(ai, board)) return -1;

        List<Cell> availableCells = gameValidator.getAvailableCells(board);

        if (availableCells.isEmpty()) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < availableCells.size(); i++) {
            Cell cell = availableCells.get(i);

            if (turn == ai) {
                gameValidator.placeAMove(board, cell, ai);
                int score = aiMove(board, human, ai, depth + 1, human, aiMove, gameValidator);
                max = Math.max(score, max);

                if (score >= 0) {
                    if (depth == 0) {
                        aiMove = cell;
                    }
                }

                if (score == 1) {
                    board[cell.getX()][cell.getY()] = Character.MIN_VALUE;
                    break;
                }

                if (i == availableCells.size() - 1 && max < 0) {
                    if (depth == 0) {
                        aiMove = cell;
                    }
                }

            } else if (turn == human) {
                gameValidator.placeAMove(board, cell, human);
                int score = aiMove(board, human, ai, depth + 1, ai, aiMove, gameValidator);
                min = Math.min(score, max);

                if (score == -1) {
                    board[cell.getX()][cell.getY()] = Character.MIN_VALUE;
                    break;
                }
            }

            board[cell.getX()][cell.getY()] = Character.MIN_VALUE;
        }

        return turn == ai ? max : min;
    }

}
