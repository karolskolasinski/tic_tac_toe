package tic_tac_toe.level;

import tic_tac_toe.game.Point;

public interface GameLevel {

    boolean placeAMove(char[][] board, Point point, char player);
}
