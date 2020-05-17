package tic_tac_toe.game;

import tic_tac_toe.level.GameLevel;

import java.util.Scanner;

class Setup {

    private Scanner scanner;
    private UserInputValidator validator;
    private GameSymbols symbols;
    private GameLevel level;

    Setup(Scanner scanner, UserInputValidator validator) {
        this.scanner = scanner;
        this.validator = validator;
    }

    /**
     *
     */
    GameSymbols assignSymbols() {
        while (symbols == null) {
            String userSymbol = scanner.nextLine().toUpperCase();
            try {
                symbols = validator.validateSelectedSymbol(userSymbol);
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
                this.level = validator.validateSelectedLevel(level);
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
        return this.level;
    }

}

