package tic_tac_toe.core;

import lombok.Data;
import lombok.NoArgsConstructor;
import tic_tac_toe.Messages;
import tic_tac_toe.level.GameLevel;
import tic_tac_toe.validator.GameValidator;
import tic_tac_toe.validator.InputValidator;

import java.util.Scanner;

@NoArgsConstructor
@Data
class Game {

    private Messages messages;
    private Scanner scanner;
    private InputValidator inputValidator;
    private char human;
    private char ai;
    private GameLevel level;
    private char[][] board = new char[3][3];
    private GameValidator gameValidator = new GameValidator();


    Game(Messages messages, Scanner scanner, InputValidator inputValidator, char human, char ai, GameLevel level) {
        this.messages = messages;
        this.scanner = scanner;
        this.inputValidator = inputValidator;
        this.human = human;
        this.ai = ai;
        this.level = level;
        initializeBoard();
    }

    /**
     *
     */
    void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     *
     */
    void playStrategy() {
        while (!gameValidator.isGameOver(board, human, ai)) {
            inputValidator.humanMove(board, human, scanner, messages, gameValidator);
            level.aiMove(board, human, ai, 0, ai, gameValidator);
            messages.displayBoard(board);
            messages.displaySummary(board, human, ai, gameValidator);
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
