package tic_tac_toe.level;

import tic_tac_toe.game.Point;

public class Hard implements GameLevel {

    @Override
    public boolean placeAMove(char[][] board, Point point, char player) {
        if (board[point.getX()][point.getY()] != Character.MIN_VALUE) {
            return false;
        }

        board[point.getX()][point.getY()] = player;
        return true;
    }


}
