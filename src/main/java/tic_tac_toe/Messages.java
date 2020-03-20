package tic_tac_toe;

class Messages {

    private String logo = "\n" +
            " ______   __     ______        ______   ______     ______        ______   ______     ______    \n" +
            "/\\__  _\\ /\\ \\   /\\  ___\\      /\\__  _\\ /\\  __ \\   /\\  ___\\      /\\__  _\\ /\\  __ \\   /\\  ___\\   \n" +
            "\\/_/\\ \\/ \\ \\ \\  \\ \\ \\____     \\/_/\\ \\/ \\ \\  __ \\  \\ \\ \\____     \\/_/\\ \\/ \\ \\ \\/\\ \\  \\ \\  __\\   \n" +
            "   \\ \\_\\  \\ \\_\\  \\ \\_____\\       \\ \\_\\  \\ \\_\\ \\_\\  \\ \\_____\\       \\ \\_\\  \\ \\_____\\  \\ \\_____\\ \n" +
            "    \\/_/   \\/_/   \\/_____/        \\/_/   \\/_/\\/_/   \\/_____/        \\/_/   \\/_____/   \\/_____/ \n" +
            "                                                                by karolskolasinski@gmail.com\n";
    private String chooseSymbol = "Select your symbol (O or X)";
    private String chooseLevel = "Select level (1 or 2 or 3)";
    private String playAgain = "Do you wanna play again?";

    void logo() {
        System.out.println(logo);
    }

    void chooseSymbol() {
        System.out.println(chooseSymbol);
    }

    void chooseLevel() {
        System.out.println(chooseLevel);

    }

    void playAgain() {
        System.out.println(playAgain);
    }

}
