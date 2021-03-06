package tic_tac_toe.level;

import tic_tac_toe.validator.GameValidator;

public interface GameLevel {

    void aiMove(char[][] board, char human, char ai, int depth, char turn, GameValidator gameValidator);
}
