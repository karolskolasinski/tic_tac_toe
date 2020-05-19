package tic_tac_toe.game;

import tic_tac_toe.Messages;
import tic_tac_toe.level.GameLevel;

import java.util.Scanner;

class Game {

    private Messages messages;
    private Scanner scanner;
    private InputValidator inputValidator;
    private char human;
    private char ai;
    private GameLevel level;
    private char[][] board = new char[3][3];
    private GameValidator gameValidator;

    Game(Messages messages, Scanner scanner, InputValidator inputValidator, char human, char ai, GameLevel level) {
        this.messages = messages;
        this.scanner = scanner;
        this.inputValidator = inputValidator;
        this.human = human;
        this.ai = ai;
        this.level = level;
        this.gameValidator = new GameValidator();
    }


    Game(Messages messages) {
        this.messages = messages;
    }

    /**
     *
     */
    void playStrategy() {
        while (gameValidator.isGameOver(board, human, ai)) {

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
                return inputValidator.validatePlayAgainAnswer(playAgain);
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }

}
