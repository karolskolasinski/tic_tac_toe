package tic_tac_toe;

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
        System.out.println("Select your symbol (o or x):");
    }

    public void displayChooseLevelMessage() {
        System.out.println("Select level (1 or 2 or 3):");
    }

    public void displayPlayAgainQuestion() {
        System.out.println("Do you wanna play again?");
    }

    public void displayBoard(char[][] board) {
//        System.out.println();
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
        System.out.println("\n " +
                board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " \n" +
                "---+---+---\n" +
                " " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " \n" +
                "---+---+---\n" +
                " " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " " +
                "\n");
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
