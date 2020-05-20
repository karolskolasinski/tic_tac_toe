package tic_tac_toe.level;

import tic_tac_toe.game.Cell;
import tic_tac_toe.game.GameValidator;

public interface GameLevel {

    int aiMove(char[][] board, char human, char ai, int depth, char turn, GameValidator gameValidator);

    Cell getAiMove();
}
