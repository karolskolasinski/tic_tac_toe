package tic_tac_toe;

import java.util.Arrays;
import java.util.Map;

public class Messages {

    private String logo = "\n" +
            " ______   __    ______        ______   ______    ______        ______   ______    ______    \n" +
            "/\\__  _\\ /\\ \\  /\\  ___\\      /\\__  _\\ /\\  __ \\  /\\  ___\\      /\\__  _\\ /\\  __ \\  /\\  ___\\   \n" +
            "\\/_/\\ \\/ \\ \\ \\ \\ \\ \\____     \\/_/\\ \\/ \\ \\  __ \\ \\ \\ \\____     \\/_/\\ \\/ \\ \\ \\/\\ \\ \\ \\  __\\   \n" +
            "   \\ \\_\\  \\ \\_\\ \\ \\_____\\       \\ \\_\\  \\ \\_\\ \\_\\ \\ \\_____\\       \\ \\_\\  \\ \\_____\\ \\ \\_____\\ \n" +
            "    \\/_/   \\/_/  \\/_____/        \\/_/   \\/_/\\/_/  \\/_____/        \\/_/   \\/_____/  \\/_____/\n" +
            "                                                             by karolskolasinski@gmail.com\n";
    private String exampleBoard = "The board has 9 fields:\n\n" +
            " 1 | 2 | 3 \n" +
            "---+---+---\n" +
            " 4 | 5 | 6 \n" +
            "---+---+---\n" +
            " 7 | 8 | 9 \n";
    private String chooseSymbol = "Select your symbol (O or X):";
    private String chooseLevel = "Select level (1 or 2 or 3):";
    private String playAgain = "Do you wanna play again?";
    private String userChoice = "Choice field (1 to 9):";

    public void logo() {
        System.out.println(logo);
        System.out.println(exampleBoard);
    }

    public void chooseSymbol() {
        System.out.println(chooseSymbol);
    }

    public void chooseLevel() {
        System.out.println(chooseLevel);

    }

    public void playAgain() {
        System.out.println(playAgain);
    }

    public void drawBoard(Map<Integer, String> board) {
        System.out.println(" " + board.get(0) + " | " + board.get(1) + " | " + board.get(2) + " \n" +
                "---+---+---\n" +
                " " + board.get(3) + " | " + board.get(4) + " | " + board.get(5) + " \n" +
                "---+---+---\n" +
                " " + board.get(6) + " | " + board.get(7) + " | " + board.get(8) + " \n");
    }

    public void userChoice() {
        System.out.println(userChoice);
    }
}
