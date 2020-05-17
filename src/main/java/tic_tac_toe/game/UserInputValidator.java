package tic_tac_toe.game;

import tic_tac_toe.level.Easy;
import tic_tac_toe.level.GameLevel;
import tic_tac_toe.level.Hard;
import tic_tac_toe.level.Medium;

import java.util.Map;

class UserInputValidator {

    GameSymbols validateSelectedSymbol(String userSymbol) {
        switch (userSymbol.toUpperCase()) {
            case "O":
                return new GameSymbols('O', 'X');
            case "X":
                return new GameSymbols('X', 'O');
            default:
                throw new IllegalArgumentException("You can choose only \"O\" or \"X\"");
        }
    }

    GameLevel validateSelectedLevel(String level) {
        switch (level) {
            case "1":
                return new Easy();
            case "2":
                return new Medium();
            case "3":
                return new Hard();
            default:
                throw new IllegalArgumentException("You can choose only 1 or 2 or 3");
        }
    }

    boolean validatePlayAgainAnswer(String playAgain) {
        switch (playAgain.toLowerCase()) {
            case "yes":
                return true;
            case "y":
                return true;
            case "no":
                return false;
            case "n":
                return false;
            default:
                throw new IllegalArgumentException("You can choose only \"yes\" or \"no\"");
        }
    }

    void wrongFieldNumberSelected(String userChoice) {
        if (userChoice.length() != 1 || userChoice.equals("0")) {
            throw new IllegalArgumentException("You can choose only fields 1 to 9");
        }
    }

    void chosenFieldIsAlreadySelected(Map<Integer, String> board, int userChoice) {
        if (!board.get(userChoice).equals(" ")) {
            throw new IllegalArgumentException("This field is already taken");
        }
    }
}
