package tic_tac_toe.core;

import tic_tac_toe.Messages;
import tic_tac_toe.level.GameLevel;
import tic_tac_toe.level.Hard;
import tic_tac_toe.level.Easy;
import tic_tac_toe.level.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Game {

    private GameLevel gameLevel;
    private Map<Integer, String> board = new HashMap<>(9);
    private Messages messages;
    private Scanner scanner;
    private UserInputValidator userInputValidator;
    private String userSymbol;
    private String computerSymbol;
    private String level;

    Game(Messages messages, Scanner scanner, UserInputValidator userInputValidator, String userSymbol, String computerSymbol, String level) {
        this.messages = messages;
        this.scanner = scanner;
        this.userInputValidator = userInputValidator;
        this.userSymbol = userSymbol;
        this.computerSymbol = computerSymbol;
        this.level = level;
        initializeBoard();
    }

    Game(Messages messages) {
        this.messages = messages;
    }

    void initializeBoard() {
        board.clear();
        for (int i = 0; i < 9; i++) {
            board.put(i, " ");
        }
    }

    private void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    private void playWithParameters() {
        boolean gameEnd = false;
        while (!gameEnd) {
            userChoice();
            gameEnd = gameStatus();
            computerChoice(gameEnd);
            gameEnd = gameStatus();
            messages.drawBoard(board);
        }
    }

    private void computerChoice(boolean gameEnd) {
        if (board.containsValue(" ") && !gameEnd) {
            int computerChoice = gameLevel.computerChoice(board, computerSymbol, userSymbol);
            applySymbol(computerChoice, computerSymbol);
        }
    }

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

    void applySymbol(int choice, String symbol) {
        board.replace(choice, symbol);
    }

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

    private boolean checkDraw() {
        if (!board.containsValue(" ")) {
            messages.displayItIsADrawMessage();
            return true;
        }
        return false;
    }

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

    void playByStrategy() {
        switch (level) {
            case "1":
                setGameLevel(new Easy());
                break;
            case "2":
                setGameLevel(new Medium());
                break;
            case "3":
                setGameLevel(new Hard());
                break;
        }
        playWithParameters();
    }

}
