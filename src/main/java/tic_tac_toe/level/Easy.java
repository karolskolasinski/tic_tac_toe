package tic_tac_toe.level;

import tic_tac_toe.model.Cell;
import tic_tac_toe.validator.GameValidator;

import java.util.List;
import java.util.Random;

public class Easy implements GameLevel {

    private Random random = new Random();

    /**
     * @param board
     * @param human
     * @param ai
     * @param depth
     * @param turn
     * @param gameValidator
     */
    @Override
    public void aiMove(char[][] board, char human, char ai, int depth, char turn, GameValidator gameValidator) {
        if (!gameValidator.isGameOver(board, human, ai)) {
            List<Cell> availableCells = gameValidator.getAvailableCells(board);
            int cellNumber = random.nextInt(availableCells.size());
            gameValidator.placeAMove(board, availableCells.get(cellNumber), ai);
        }
    }
}
