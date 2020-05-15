package tic_tac_toe.core;

import tic_tac_toe.Messages;

import java.util.Scanner;

public class TicTacToe {

    /*VARIABLES*/
    private Messages messages = new Messages();
    private Scanner scanner = new Scanner(System.in);
    private UserInputValidator userInputValidator = new UserInputValidator();
    private String userSymbol;
    private String computerSymbol;
    private String level;
    private Boolean playAgain;

    /*PARSER*/
    public void run() {
        messages.displayLogo();
        do {
            setupGame();
            play();
            playAgain();
        } while (playAgain);
    }

    /*METHODS*/
    private void setupGame() {
        messages.displayChooseSymbolMessage();
        assignSymbols();
        messages.displayChooseLevelMessage();
        assignLevel();
        messages.displayBeginMessage();
    }

    private void assignSymbols() {
        this.userSymbol = null;
        while (this.userSymbol == null) {
            String userSymbol = scanner.nextLine().toUpperCase();
            try {
                userInputValidator.wrongSymbolSelected(userSymbol);
                this.userSymbol = userSymbol;
                switch (this.userSymbol) {
                    case "O":
                        computerSymbol = "X";
                        break;
                    case "0":
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

    private void assignLevel() {
        this.level = null;
        while (this.level == null) {
            String level = scanner.nextLine();
            try {
                userInputValidator.wrongLevelSelected(level);
                this.level = level;
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }

    private void play() {
        Game game = new Game(messages, scanner, userInputValidator, userSymbol, computerSymbol, level);
        game.playByStrategy();
    }

    private void playAgain() {
        messages.displayPlayAgainQuestion();
        this.playAgain = null;
        while (this.playAgain == null) {
            String playAgain = scanner.nextLine();
            try {
                userInputValidator.wrongPlayAgainAnswerSelected(playAgain);
                this.playAgain = playAgain.equalsIgnoreCase("yes");
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }


}
