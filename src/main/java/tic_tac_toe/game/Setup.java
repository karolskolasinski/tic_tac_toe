package tic_tac_toe.game;

import tic_tac_toe.level.GameLevel;

import java.util.Scanner;

class Setup {

    private Scanner scanner;
    private InputValidator inputValidator;
    private GameSymbols symbols;
    private GameLevel level;

    Setup(Scanner scanner, InputValidator inputValidator) {
        this.scanner = scanner;
        this.inputValidator = inputValidator;
    }

    /**
     *
     */
    GameSymbols assignSymbols() {
        while (symbols == null) {
            String userSymbol = scanner.nextLine().toUpperCase();
            try {
                symbols = inputValidator.validateSelectedSymbol(userSymbol);
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }

        return symbols;
    }

    /**
     *
     */
    GameLevel assignLevel() {
        while (this.level == null) {
            String level = scanner.nextLine();
            try {
                this.level = inputValidator.validateSelectedLevel(level);
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }

        return this.level;
    }

}
