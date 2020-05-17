package tic_tac_toe.game;

import tic_tac_toe.Messages;

import java.util.Scanner;

public class TicTacToe {

    private Messages messages = new Messages();
    private Scanner scanner = new Scanner(System.in);
    private UserInputValidator validator = new UserInputValidator();
    private Character human;
    private Character ai;
    private String level;
    private Boolean playAgain;

    /**
     *
     */
    public void run() {
        messages.displayLogo();
        do {
            setup();
            play();
            playAgain();
        } while (playAgain);
    }

    /**
     *
     */
    private void setup() {
        Setup setup = new Setup(scanner, validator);
        assignSymbols(setup);
        assignLevel(setup);
    }

    /**
     *
     */
    private void assignLevel(Setup setup) {
        messages.displayChooseLevelMessage();
        this.level = setup.assignLevel();
        messages.displayBeginMessage();
    }

    /**
     *
     */
    private void assignSymbols(Setup setup) {
        messages.displayChooseSymbolMessage();
        Character[] symbols = setup.assignSymbols();
        this.human = symbols[0];
        this.ai = symbols[1];
    }

    /**
     *
     */
    private void play() {
        Board board = new Board(messages, scanner, validator, human, ai, level);
        board.playByStrategy();
    }

    /**
     *
     */
    private void playAgain() {
        messages.displayPlayAgainQuestion();
        this.playAgain = null;
        while (this.playAgain == null) {
            String playAgain = scanner.nextLine();
            try {
                validator.wrongPlayAgainAnswerSelected(playAgain);
                this.playAgain = playAgain.equalsIgnoreCase("yes");
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }


}
