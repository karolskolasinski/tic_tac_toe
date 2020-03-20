package tic_tac_toe;

import java.util.Scanner;

class BoardController {

    private String[][] board = new String[3][3];

    void playWithParameters(Scanner scanner, Messages messages, String userSymbol, String computerSymbol, String level) {
        boolean gameEnd = false;
        do {
            drawBoard();
            tick();
            gameEnd = gameStatus();
        } while (!gameEnd);
    }
}
