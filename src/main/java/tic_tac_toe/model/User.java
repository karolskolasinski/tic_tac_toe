package tic_tac_toe.model;

import tic_tac_toe.Messages;
import tic_tac_toe.validator.GameValidator;
import tic_tac_toe.validator.InputValidator;

import java.util.Scanner;

public class User {

    public void humanMove(char[][] board, char human, Scanner scanner, Messages messages, InputValidator inputValidator, GameValidator gameValidator) {
        boolean moveOk = false;

        while (!moveOk) {
            messages.displayUserChoiceOptions();
            String userMove = scanner.nextLine();

            try {
                Cell cell = inputValidator.validateTakenFieldNumber(userMove);
                gameValidator.placeAMove(board, cell, human);
                moveOk = true;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
