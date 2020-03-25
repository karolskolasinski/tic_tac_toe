package tic_tac_toe.controller;

import tic_tac_toe.Messages;
import tic_tac_toe.level.GameLevel;
import tic_tac_toe.level.Hard;
import tic_tac_toe.level.Easy;
import tic_tac_toe.level.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BoardController {

    private GameLevel gameLevel;
    private Map<Integer, String> board = new HashMap<>(9);
    private Messages messages;
    private Scanner scanner;
    private ExceptionController exceptionController;
    private String userSymbol;
    private String computerSymbol;
    private String level;
    private int userChoice;

    BoardController(Messages messages, Scanner scanner, ExceptionController exceptionController, String userSymbol, String computerSymbol, String level) {
        this.messages = messages;
        this.scanner = scanner;
        this.exceptionController = exceptionController;
        this.userSymbol = userSymbol;
        this.computerSymbol = computerSymbol;
        this.level = level;
        initializeBoard();
    }

    BoardController(Messages messages) {
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
        messages.userChoice();
        this.userChoice = -1;
        while (this.userChoice == -1) {
            String userChoice = scanner.nextLine();
            try {
                exceptionController.wrongFieldNumberSelected(userChoice);
                this.userChoice = Integer.parseInt(userChoice) - 1;
                exceptionController.chosenFieldIsAlreadySelected(board, this.userChoice);
                applySymbol(this.userChoice, userSymbol);
            } catch (IllegalArgumentException iae) {
                if (iae instanceof NumberFormatException) {
                    System.err.println("You have to provide number only");
                } else {
                    System.err.println(iae.getMessage());
                    this.userChoice = -1;
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
            messages.itIsADraw();
            return true;
        }
        return false;
    }

    private boolean checkLine(int a, int b, int c) {
        if (board.get(a).equals(board.get(b)) && board.get(a).equals(board.get(c)) && !board.get(a).equals(" ")) {
            if (board.get(a).equals(userSymbol)) {
                messages.youWon();
            } else {
                messages.youLost();
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
