package tic_tac_toe.game;

import tic_tac_toe.Messages;
import tic_tac_toe.level.GameLevel;

import java.util.Scanner;

public class TicTacToe {

    private Messages messages = new Messages();
    private Scanner scanner = new Scanner(System.in);
    private InputValidator inputValidator = new InputValidator();
    private char human;
    private char ai;
    private GameLevel level;
    private boolean playAgain;

    /**
     *
     */
    public void run() {
        messages.displayLogo();
        do {
            setup();
            play();
        } while (playAgain);
    }

    /**
     *
     */
    private void setup() {
        Setup setup = new Setup(scanner, inputValidator);
        setSymbols(setup);
        setLevel(setup);
        messages.displayBeginMessage();
    }

    /**
     *
     */
    private void setLevel(Setup setup) {
        messages.displayChooseLevelMessage();
        this.level = setup.assignLevel();
    }

    /**
     *
     */
    private void setSymbols(Setup setup) {
        messages.displayChooseSymbolMessage();
        GameSymbols symbols = setup.assignSymbols();
        this.human = symbols.getHuman();
        this.ai = symbols.getAi();
    }

    /**
     *
     */
    private void play() {
        Game game = new Game(messages, scanner, inputValidator, human, ai, level);
        game.playStrategy();
        playAgain = game.playAgain();
    }

}
