package tic_tac_toe.controller;

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
        if (!playAgain.equals("yes") && !playAgain.equals("no")) {
            throw new IllegalArgumentException("You can choose only \"yes\" or \"no\"");
        }
    }

    void wrongFieldNumberSelected(String userChoice) {
        if (userChoice.length() != 1) {
            throw new IllegalArgumentException("You can choose only fields 1 to 9");
        }
    }

    void choosedFieldIsAlreadySelected(String field) {
        if (!field.isEmpty()) {
            throw new IllegalArgumentException("This field is already taken");
        }
    }
}
