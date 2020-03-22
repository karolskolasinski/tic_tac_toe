package tic_tac_toe;

public class Messages {

    private String logo = "\n" +
            " ______   __    ______        ______   ______    ______        ______   ______    ______    \n" +
            "/\\__  _\\ /\\ \\  /\\  ___\\      /\\__  _\\ /\\  __ \\  /\\  ___\\      /\\__  _\\ /\\  __ \\  /\\  ___\\   \n" +
            "\\/_/\\ \\/ \\ \\ \\ \\ \\ \\____     \\/_/\\ \\/ \\ \\  __ \\ \\ \\ \\____     \\/_/\\ \\/ \\ \\ \\/\\ \\ \\ \\  __\\   \n" +
            "   \\ \\_\\  \\ \\_\\ \\ \\_____\\       \\ \\_\\  \\ \\_\\ \\_\\ \\ \\_____\\       \\ \\_\\  \\ \\_____\\ \\ \\_____\\ \n" +
            "    \\/_/   \\/_/  \\/_____/        \\/_/   \\/_/\\/_/  \\/_____/        \\/_/   \\/_____/  \\/_____/\n" +
            "                                                             by karolskolasinski@gmail.com\n";
    private String chooseSymbol = "Select your symbol (O or X):";
    private String chooseLevel = "Select level (1 or 2 or 3):";
    private String playAgain = "Do you wanna play again?";
    private String userChoice = "Choice field (1 to 9):";

    public void logo() {
        System.out.println(logo);
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

    //todo
    public void drawBoard(String[][] board) {

    }

    public void userChoice() {
        System.out.println(userChoice);
    }
}
