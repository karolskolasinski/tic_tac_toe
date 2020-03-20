package tic_tac_toe;

import java.util.Scanner;

class GameController {

    /*VARIABLES*/
    private Messages messages = new Messages();
    private Scanner scanner = new Scanner(System.in);
    private ExceptionController exceptionController = new ExceptionController();
    private String userSymbol;
    private String computerSymbol;
    private String level;
    private BoardController boardController;
    private String playAgain;


    void run() {
        messages.logo();
        boolean flag;
        do {
            setupGame();
            play();
            flag = playAgain();
        } while (!flag);
    }

    private boolean playAgain() {
        playAgain = null;
        while (playAgain == null) {
            String playAgain = scanner.nextLine();
            try {


            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }

    }

    private void setupGame() {
        messages.chooseSymbol();
        assignSymbols();
        messages.chooseLevel();
        assignLevel();
    }

    private void assignLevel() {
        level = null;
        while (level == null) {
            String level = scanner.nextLine();
            try {
                exceptionController.level(level);
                this.level = level;
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }
    }

    private void assignSymbols() {
        userSymbol = null;
        while (userSymbol == null) {
            String userSymbol = scanner.nextLine().toUpperCase();
            try {
                exceptionController.symbol(userSymbol);
                this.userSymbol = userSymbol;

                switch (this.userSymbol) {
                    case "O":
                        computerSymbol = "X";
                        break;
                    case "X":
                        computerSymbol = "O";
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.err.println(iae.getMessage());
            }
        }

    }

    private boolean play() {
        return boardController.playWithParameters(userSymbol, computerSymbol, level);
    }


}
