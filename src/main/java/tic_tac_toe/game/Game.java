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
    private GameValidator gameValidator;

    public Game(GameLevel level, char[][] board, Messages messages, Scanner scanner, UserInputValidator validator, char human, char ai) {
        this.level = level;
        this.board = board;
        this.messages = messages;
        this.scanner = scanner;
        this.validator = validator;
        this.human = human;
        this.ai = ai;
        this.gameValidator = new GameValidator(this.board, this.human, this.ai);
    }

    Game(Messages messages) {
        this.messages = messages;
    }

    /**
     *
     */
    void playStrategy() {
        boolean gameEnd = false;
        while (gameValidator.isGameOver()) {
            level.aiMove(board, gameValidator);
        }
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
