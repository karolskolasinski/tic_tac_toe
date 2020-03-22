package tic_tac_toe.controller;

import java.util.Map;

class ExceptionController {

    void wrongSymbolSelected(String userSymbol) {
        if (!userSymbol.equals("O") && !userSymbol.equals("X")) {
            throw new IllegalArgumentException("You can choose only \"O\" or \"X\"");
        }
    }

    void wrongLevelSelected(String level) {
        if (!level.equals("1") && !level.equals("2") && !level.equals("3")) {
            throw new IllegalArgumentException("You can choose only 1 or 2 or 3");
        }
    }

    void wrongPlayAgainAnswerSelected(String playAgain) {
        if (!playAgain.equalsIgnoreCase("yes") && !playAgain.equalsIgnoreCase("no")) {
            throw new IllegalArgumentException("You can choose only \"yes\" or \"no\"");
        }
    }

    void wrongFieldNumberSelected(String userChoice) {
        if (userChoice.length() != 1 || userChoice.equals("0")) {
            throw new IllegalArgumentException("You can choose only fields 1 to 9");
        }
    }

    void chosedFieldIsAlreadySelected(Map<Integer, String> board, int userChoice) {
        if (!board.get(userChoice).equals(" ")) {
            throw new IllegalArgumentException("This field is already taken");
        }
    }
}
