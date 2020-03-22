package tic_tac_toe.controller;

import tic_tac_toe.Messages;

import java.util.Scanner;

public class GameController {

    /*VARIABLES*/
    private Messages messages = new Messages();
    private Scanner scanner = new Scanner(System.in);
    private ExceptionController exceptionController = new ExceptionController();
    private String userSymbol;
    private String computerSymbol;
    private String level;
    private Boolean playAgain;

    /*PARSER*/
    public void run() {
        messages.logo();
        do {
            setupGame();
            play();
            playAgain();
        } while (playAgain);
    }

    /*METHODS*/
    private void playAgain() {
        messages.playAgain();
        this.playAgain = null;
        while (this.playAgain == null) {
            String playAgain = scanner.nextLine();
            try {
                exceptionController.wrongPlayAgainAnswerSelected(playAgain);
                this.playAgain = playAgain.equalsIgnoreCase("yes");
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }

    private void setupGame() {
        messages.chooseSymbol();
        assignSymbols();
        messages.chooseLevel();
        assignLevel();
        messages.begin();
    }

    private void assignLevel() {
        this.level = null;
        while (this.level == null) {
            String level = scanner.nextLine();
            try {
                exceptionController.wrongLevelSelected(level);
                this.level = level;
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }

    private void assignSymbols() {
        this.userSymbol = null;
        while (this.userSymbol == null) {
            String userSymbol = scanner.nextLine().toUpperCase();
            try {
                exceptionController.wrongSymbolSelected(userSymbol);
                this.userSymbol = userSymbol;
                switch (this.userSymbol) {
                    case "O":
                        computerSymbol = "X";
                        break;
                    case "X":
                        computerSymbol = "O";
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }

    private void play() {
        BoardController boardController = new BoardController(messages, scanner, exceptionController, userSymbol, computerSymbol, level);
        boardController.playByStrategy();
    }


}
