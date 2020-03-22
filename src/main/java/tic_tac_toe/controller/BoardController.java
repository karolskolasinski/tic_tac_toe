package tic_tac_toe.controller;

import tic_tac_toe.Messages;
import tic_tac_toe.level.ChuckNorris;
import tic_tac_toe.level.Easy;
import tic_tac_toe.level.Medium;

import java.util.Scanner;

class BoardController {

    private GameLevel gameLevel;
    private String[][] board = new String[3][3];
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
    }

    private void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    private void playWithParameters() {
        boolean gameEnd = false;
        do {
            messages.drawBoard(board);
            messages.userChoice();
            userChoice(board);
            board = gameLevel.computerChoice(board, computerSymbol);
            gameEnd = gameStatus();
        } while (!gameEnd);
    }

    private void userChoice(String[][] board) {
        this.userChoice = -1;
        while (this.userChoice == -1) {
            String userChoice = scanner.nextLine();
            try {
                exceptionController.wrongFieldNumberSelected(userChoice);
                this.userChoice = Integer.parseInt(userChoice);
                exceptionController.choosedFieldIsAlreadySelected(getBoardField(this.userChoice));
                applySymbol(this.userChoice, userSymbol);
            } catch (IllegalArgumentException iae) {
                if (iae instanceof NumberFormatException) {
                    System.err.println("You have to provide number only");
                } else {
                    System.err.println(iae.getMessage());
                }
            }
        }
    }

    private String getBoardField(int choice) {
        switch (choice) {
            case 1:
                return board[0][0];
            case 2:
                return board[0][1];
            case 3:
                return board[0][2];
            case 4:
                return board[1][0];
            case 5:
                return board[1][1];
            case 6:
                return board[1][2];
            case 7:
                return board[2][0];
            case 8:
                return board[2][1];
            case 9:
                return board[2][2];
            default:
                return null;
        }
    }

    private void applySymbol(int choice, String symbol) {
        switch (choice) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
        }
    }

    private void assignSymbolToField(String field) {

        exceptionController.choosedFieldIsAlreadySelected(field);

    }

    //todo
    private boolean gameStatus() {

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
                setGameLevel(new ChuckNorris());
                break;
        }
        playWithParameters();
    }

}
