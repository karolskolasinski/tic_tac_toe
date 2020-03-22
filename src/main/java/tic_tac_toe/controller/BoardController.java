package tic_tac_toe.controller;

import tic_tac_toe.Messages;
import tic_tac_toe.level.ChuckNorris;
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

    private void initializeBoard() {
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
        do {
            messages.userChoice();
            userChoice();
//            board = gameLevel.computerChoice(board, computerSymbol);
            messages.drawBoard(board);
            gameEnd = gameStatus();
        } while (!gameEnd);
    }

    private void userChoice() {
        this.userChoice = -1;
        while (this.userChoice == -1) {
            String userChoice = scanner.nextLine();
            try {
                exceptionController.wrongFieldNumberSelected(userChoice);
                this.userChoice = Integer.parseInt(userChoice);
                exceptionController.chosedFieldIsAlreadySelected(board, this.userChoice);
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

    private void applySymbol(int choice, String symbol) {
        board.replace(choice, symbol);
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
