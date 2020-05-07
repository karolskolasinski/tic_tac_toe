package tic_tac_toe;

import java.util.Map;

public class Messages {

    public void displayLogo() {
        System.out.println("\n" +
                " ______   __    ______        ______   ______    ______        ______   ______    ______    \n" +
                "/\\__  _\\ /\\ \\  /\\  ___\\      /\\__  _\\ /\\  __ \\  /\\  ___\\      /\\__  _\\ /\\  __ \\  /\\  ___\\   \n" +
                "\\/_/\\ \\/ \\ \\ \\ \\ \\ \\____     \\/_/\\ \\/ \\ \\  __ \\ \\ \\ \\____     \\/_/\\ \\/ \\ \\ \\/\\ \\ \\ \\  __\\   \n" +
                "   \\ \\_\\  \\ \\_\\ \\ \\_____\\       \\ \\_\\  \\ \\_\\ \\_\\ \\ \\_____\\       \\ \\_\\  \\ \\_____\\ \\ \\_____\\ \n" +
                "    \\/_/   \\/_/  \\/_____/        \\/_/   \\/_/\\/_/  \\/_____/        \\/_/   \\/_____/  \\/_____/\n" +
                "                                                             by karolskolasinski@gmail.com\n");

        System.out.println("The board has 9 fields:\n\n" +
                " 1 | 2 | 3 \n" +
                "---+---+---\n" +
                " 4 | 5 | 6 \n" +
                "---+---+---\n" +
                " 7 | 8 | 9 \n");
    }

    public void displayChooseSymbolMessage() {
        System.out.println("Select your symbol (O or X):");
    }

    public void displayChooseLevelMessage() {
        System.out.println("Select level (1 or 2 or 3):");
    }

    public void displayPlayAgainQuestion() {
        System.out.println("Do you wanna play again?");
    }

    public void drawBoard(Map<Integer, String> board) {
        System.out.println("\n " + board.get(0) + " | " + board.get(1) + " | " + board.get(2) + " \n" +
                "---+---+---\n" +
                " " + board.get(3) + " | " + board.get(4) + " | " + board.get(5) + " \n" +
                "---+---+---\n" +
                " " + board.get(6) + " | " + board.get(7) + " | " + board.get(8) + " \n");
    }

    public void displayUserChoiceOptions() {
        System.out.println("Choice field (1 to 9):");
    }

    public void displayBeginMessage() {
        System.out.println("OK! Let's play!\n");
    }

    public void displayYouWonMessage() {
        System.out.println("YOU WON!");
    }

    public void displayYouLostMessage() {
        System.out.println("YOU LOST!");
    }

    public void displayItIsADrawMessage() {
        System.out.println("IT'S A DRAW!");
    }
}
