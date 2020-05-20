package tic_tac_toe.level;

import tic_tac_toe.game.Cell;
import tic_tac_toe.game.GameValidator;

import java.util.List;
import java.util.Random;

public class Easy implements GameLevel {

    private Random random = new Random();

    @Override
    public void aiMove(char[][] board, char human, char ai, int depth, char turn, GameValidator gameValidator) {
        List<Cell> availableCells = gameValidator.getAvailableCells(board);
        int cellNumber = random.nextInt(availableCells.size());

        gameValidator.placeAMove(board,availableCells.get(cellNumber), ai);
    }
}
