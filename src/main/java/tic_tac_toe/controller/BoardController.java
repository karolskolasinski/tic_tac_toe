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
            userTick();
            board = gameLevel.computerChoose(board, computerSymbol);
            gameEnd = gameStatus();
        } while (!gameEnd);
    }

    //todo
    private void userTick() {


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
