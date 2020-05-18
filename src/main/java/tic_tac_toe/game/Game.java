package tic_tac_toe.game;

import tic_tac_toe.Messages;
import tic_tac_toe.level.GameLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Game {

    private GameLevel level;
    private char[][] board = new char[3][3];
    private Messages messages;
    private Scanner scanner;
    private UserInputValidator validator;
    private char human;
    private char ai;

    Game(Messages messages, Scanner scanner, UserInputValidator validator, char human, char ai, GameLevel level) {
        this.messages = messages;
        this.scanner = scanner;
        this.validator = validator;
        this.human = human;
        this.ai = ai;
        this.level = level;
    }

    Game(Messages messages) {
        this.messages = messages;
    }

    /**
     *
     */
    void playStrategy() {
        boolean gameEnd = false;
        while (isGameOver()) {

        }
    }

    /**
     *
     */
    private boolean isGameOver() {
        return hasPlayerWon(human) || hasPlayerWon(ai) || getAvailableCells().isEmpty();
    }

    /**
     *
     */
    private boolean hasPlayerWon(char player) {
        //diagonal
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == player ||
                board[0][2] == board[1][1] && board[0][0] == board[2][0] && board[0][0] == player) {
            return true;
        }

        //horizontal + vertical
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == player ||
                    board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == player) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     */
    private List<Point> getAvailableCells() {
        List<Point> availableCells = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == Character.MIN_VALUE) {
                    availableCells.add(new Point(i, j));
                }
            }
        }

        return availableCells;
    }

    /**
     *
     */
    boolean playAgain() {
        messages.displayPlayAgainQuestion();

        while (true) {
            String playAgain = scanner.nextLine();

            try {
                return validator.validatePlayAgainAnswer(playAgain);
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }

}
