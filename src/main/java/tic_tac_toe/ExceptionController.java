package tic_tac_toe;

class ExceptionController {

    void symbol(String userSymbol) {
        if (!userSymbol.equals("O") && !userSymbol.equals("X")) {
            throw new IllegalArgumentException("You can choose only \"O\" or \"X\"");
        }
    }

    void level(String level) {
        if (!level.equals("1") && !level.equals("2") && !level.equals("3")) {
            throw new IllegalArgumentException("You can choose only 1 or 2 or 3");
        }
    }
}
