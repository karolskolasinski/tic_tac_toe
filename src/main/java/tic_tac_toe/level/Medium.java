package tic_tac_toe.level;

import tic_tac_toe.model.Cell;
import tic_tac_toe.validator.GameValidator;

import java.util.List;
import java.util.Random;


public class Medium implements GameLevel {

    private Random random = new Random();
    private char[][] board;

    @Override
    public void aiMove(char[][] board, char human, char ai, int depth, char turn, GameValidator gameValidator) {
        this.board = board;

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

            //attack
            for (int i = 0; i < 3; i++) {
                if (checkHorizontalLines(board, ai, ai, i)) return;
                if (checkVerticalLines(board, ai, ai, i)) return;
            }

            //defence
            for (int i = 0; i < 3; i++) {
                if (checkHorizontalLines(board, human, ai, i)) return;
                if (checkVerticalLines(board, human, ai, i)) return;
            }

            int i = random.nextInt(availableCells.size());
            gameValidator.placeAMove(board, availableCells.get(i), ai);
        }
    }

    private boolean checkHorizontalLines(char[][] board, char player, char ai, int i) {
        if (checkLineHorizontal(i, player, 0, 1, 2)) {
            board[i][2] = ai;
            return true;
        }

        if (checkLineHorizontal(i, player, 1, 2, 0)) {
            board[i][0] = ai;
            return true;
        }

        if (checkLineHorizontal(i, player, 0, 2, 1)) {
            board[i][1] = ai;
            return true;
        }
        return false;
    }

    private boolean checkVerticalLines(char[][] board, char player, char ai, int i) {
        if (checkLineVertical(i, player, 0, 1, 2)) {
            board[2][i] = ai;
            return true;
        }

        if (checkLineVertical(i, player, 1, 2, 0)) {
            board[0][i] = ai;
            return true;
        }

        if (checkLineVertical(i, player, 0, 2, 1)) {
            board[1][i] = ai;
            return true;
        }
        return false;
    }

    private boolean checkLineHorizontal(int i, char player, int one, int two, int three) {
        return board[i][one] == player && board[i][two] == player && board[i][three] == ' ';
    }

    private boolean checkLineVertical(int i, char player, int one, int two, int three) {
        return board[one][i] == player && board[two][i] == player && board[three][i] == ' ';
    }


}
