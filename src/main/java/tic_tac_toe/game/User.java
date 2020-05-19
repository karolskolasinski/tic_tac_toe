package tic_tac_toe.game;

import tic_tac_toe.Messages;

import java.util.Scanner;

class User {

    void humanMove(char[][] board, char human, Scanner scanner, Messages messages, InputValidator inputValidator, GameValidator gameValidator) {
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
