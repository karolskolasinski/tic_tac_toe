package tic_tac_toe.level;

import tic_tac_toe.model.Cell;
import tic_tac_toe.validator.GameValidator;

import java.util.List;
import java.util.Random;


public class Medium implements GameLevel {
    private Random random = new Random();

    @Override
    public void aiMove(char[][] board, char human, char ai, int depth, char turn, GameValidator gameValidator) {
        if (!gameValidator.isGameOver(board, human, ai)) {
            List<Cell> availableCells = gameValidator.getAvailableCells(board);

            for (Cell availableCell : availableCells) {
                gameValidator.placeAMove(board, availableCell, ai);

                if (gameValidator.isGameOver(board, human, ai)) {
                    return;
                } else {
                    board[availableCell.getX()][availableCell.getY()] = ' ';
                }
            }

            int i = random.nextInt(availableCells.size());
            gameValidator.placeAMove(board, availableCells.get(i), ai);
        }
    }
}
