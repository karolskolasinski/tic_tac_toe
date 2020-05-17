package tic_tac_toe.game;

import tic_tac_toe.Messages;

import java.util.Arrays;
import java.util.Scanner;

class Setup {

    private Scanner scanner;
    private UserInputValidator validator;
    private Character[] symbols = new Character[2];
    private String level;

    Setup(Scanner scanner, UserInputValidator validator) {
        this.scanner = scanner;
        this.validator = validator;
    }

    /**
     *
     */
    Character[] assignSymbols() {
        while (Arrays.asList(symbols).contains(null)) {
            String userSymbol = scanner.nextLine().toUpperCase();
            try {
                validator.wrongSymbolSelected(userSymbol);
                if (userSymbol.equals("O") || userSymbol.equals("0")) {
                    symbols[0] = 'O';
                    symbols[1] = 'X';
                } else {
                    symbols[0] = 'X';
                    symbols[1] = 'O';
                }
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
        return symbols;
    }

    /**
     *
     */
    String assignLevel() {
        while (this.level == null) {
            String level = scanner.nextLine();
            try {
                validator.wrongLevelSelected(level);
                this.level = level;
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
        return level;
    }

}

