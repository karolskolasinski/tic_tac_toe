package tic_tac_toe.level;

import tic_tac_toe.model.Cell;
import tic_tac_toe.validator.GameValidator;

import java.util.List;
import java.util.Random;


public class Medium implements GameLevel {

    private Random random = new Random();
    char[][] board;

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
                if (board[i][0] == ai && board[i][1] == ai && board[i][2] == ' ') {
                    board[i][2] = ai;
                    return;
                }

                if (board[i][1] == ai && board[i][2] == ai && board[i][0] == ' ') {
                    board[i][0] = ai;
                    return;
                }

                if (board[i][0] == ai && board[i][2] == ai && board[i][1] == ' ') {
                    board[i][1] = ai;
                    return;
                }

                if (board[0][i] == ai && board[1][i] == ai && board[2][i] == ' ') {
                    board[2][i] = ai;
                    return;
                }

                if (board[1][i] == ai && board[2][i] == ai && board[0][i] == ' ') {
                    board[0][i] = ai;
                    return;
                }

                if (board[0][i] == ai && board[2][i] == ai && board[1][i] == ' ') {
                    board[1][i] = ai;
                    return;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (board[i][0] == human && board[i][1] == human && board[i][2] == ' ') {
                    board[i][2] = ai;
                    return;
                }

                if (board[i][1] == human && board[i][2] == human && board[i][0] == ' ') {
                    board[i][0] = ai;
                    return;
                }

                if (board[i][0] == human && board[i][2] == human && board[i][1] == ' ') {
                    board[i][1] = ai;
                    return;
                }

                if (board[0][i] == human && board[1][i] == human && board[2][i] == ' ') {
                    board[2][i] = ai;
                    return;
                }

                if (board[1][i] == human && board[2][i] == human && board[0][i] == ' ') {
                    board[0][i] = ai;
                    return;
                }

                if (board[0][i] == human && board[2][i] == human && board[1][i] == ' ') {
                    board[1][i] = ai;
                    return;
                }
            }

            int i = random.nextInt(availableCells.size());
            gameValidator.placeAMove(board, availableCells.get(i), ai);
        }
    }


}
