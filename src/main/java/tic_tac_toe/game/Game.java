package tic_tac_toe.game;

import tic_tac_toe.Messages;
import tic_tac_toe.level.GameLevel;

import java.util.Scanner;

class Game {

    private GameLevel level;
    private char[][] board = new char[3][3];
    private Messages messages;
    private Scanner scanner;
    private UserInputValidator validator;
    private char human;
    private char ai;
    private boolean playAgain = false;

    Game(Messages messages, Scanner scanner, UserInputValidator validator, char human, char ai, GameLevel level) {
        this.messages = messages;
        this.scanner = scanner;
        this.validator = validator;
        this.human = human;
        this.ai = ai;
        this.level = level;
        initializeBoard();
    }

    Game(Messages messages) {
        this.messages = messages;
    }

    /**
     *
     */
    void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board.put(i, " ");
        }
    }

    /**
     *
     */
    void playByStrategy() {
        boolean gameEnd = false;
        while (!gameEnd) {
            userChoice();
            gameEnd = gameStatus();
            computerChoice(gameEnd);
            gameEnd = gameStatus();
            messages.drawBoard(board);
        }
    }

    /**
     *
     */
    private void computerChoice(boolean gameEnd) {
        if (board.containsValue(" ") && !gameEnd) {
            int computerChoice = gameLevel.computerChoice(board, computerSymbol, userSymbol);
            applySymbol(computerChoice, computerSymbol);
        }
    }

    /**
     *
     */
    private void userChoice() {
        messages.displayUserChoiceOptions();
        int userChoice = -1;
        while (userChoice == -1) {
            String userAnswer = scanner.nextLine();
            try {
                userInputValidator.wrongFieldNumberSelected(userAnswer);
                userChoice = Integer.parseInt(userAnswer) - 1;
                userInputValidator.chosenFieldIsAlreadySelected(board, userChoice);
                applySymbol(userChoice, userSymbol);
            } catch (IllegalArgumentException iae) {
                if (iae instanceof NumberFormatException) {
                    System.err.println("You have to provide number only");
                } else {
                    System.err.println(iae.getMessage());
                    userChoice = -1;
                }
            }
        }
    }

    /**
     *
     */
    void applySymbol(int choice, String symbol) {
        board.replace(choice, symbol);
    }

    /**
     *
     */
    boolean gameStatus() {
        /*horizontal*/
        if (checkLine(0, 1, 2)) return true;
        if (checkLine(3, 4, 5)) return true;
        if (checkLine(6, 7, 8)) return true;

        /*vertical*/
        if (checkLine(0, 3, 6)) return true;
        if (checkLine(1, 4, 7)) return true;
        if (checkLine(2, 5, 8)) return true;

        /*diagonal*/
        if (checkLine(0, 4, 8)) return true;
        if (checkLine(2, 4, 6)) return true;

        /*draw*/
        return checkDraw();
    }

    /**
     *
     */
    private boolean checkDraw() {
        if (!board.containsValue(" ")) {
            messages.displayItIsADrawMessage();
            return true;
        }
        return false;
    }

    /**
     *
     */
    private boolean checkLine(int a, int b, int c) {
        if (board.get(a).equals(board.get(b)) && board.get(a).equals(board.get(c)) && !board.get(a).equals(" ")) {
            if (board.get(a).equals(userSymbol)) {
                messages.displayYouWonMessage();
            } else {
                messages.displayYouLostMessage();
            }
            return true;
        }
        return false;
    }

    /**
     *
     */
    boolean playAgain() {
        messages.displayPlayAgainQuestion();
        while (!this.playAgain) {
            String playAgain = scanner.nextLine();
            try {
                this.playAgain = validator.validatePlayAgainAnswer(playAgain);
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
        return this.playAgain;
    }

}
