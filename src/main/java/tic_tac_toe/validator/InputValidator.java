package tic_tac_toe.validator;

import tic_tac_toe.Messages;
import tic_tac_toe.model.Cell;
import tic_tac_toe.model.GameSymbols;
import tic_tac_toe.level.GameLevel;
import tic_tac_toe.level.Easy;
import tic_tac_toe.level.Medium;
import tic_tac_toe.level.Hard;

import java.util.Scanner;


public class InputValidator {

    /**
     * @param human
     */
    public GameSymbols validateSelectedSymbol(String human) {
        switch (human.toUpperCase()) {
            case "O":
                return new GameSymbols('O', 'X');
            case "X":
                return new GameSymbols('X', 'O');
            default:
                throw new IllegalArgumentException("You can choose only \"O\" or \"X\"");
        }
    }

    /**
     * @param level
     */
    public GameLevel validateSelectedLevel(String level) {
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

    /**
     * @param playAgain
     */
    public boolean validatePlayAgainAnswer(String playAgain) {
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

    /**
     * @param userMove
     */
    public Cell validateTakenFieldNumber(String userMove) {
        switch (userMove) {
            case "1":
                return new Cell(0, 0);
            case "2":
                return new Cell(0, 1);
            case "3":
                return new Cell(0, 2);
            case "4":
                return new Cell(1, 0);
            case "5":
                return new Cell(1, 1);
            case "6":
                return new Cell(1, 2);
            case "7":
                return new Cell(2, 0);
            case "8":
                return new Cell(2, 1);
            case "9":
                return new Cell(2, 2);
            default:
                throw new IllegalArgumentException("You can choose only fields 1 to 9");
        }
    }

    public void humanMove(char[][] board, char human, Scanner scanner, Messages messages, GameValidator gameValidator) {
        boolean moveOk = false;

        while (!moveOk) {
            messages.displayUserChoiceOptions();
            String userMove = scanner.nextLine();

            try {
                Cell cell = validateTakenFieldNumber(userMove);
                gameValidator.placeAMove(board, cell, human);
                moveOk = true;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
