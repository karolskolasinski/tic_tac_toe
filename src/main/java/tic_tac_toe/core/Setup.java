package tic_tac_toe.core;

import tic_tac_toe.level.GameLevel;
import tic_tac_toe.model.GameSymbols;
import tic_tac_toe.validator.InputValidator;

import java.util.Scanner;

class Setup {

    private final Scanner scanner;
    private final InputValidator inputValidator;
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
