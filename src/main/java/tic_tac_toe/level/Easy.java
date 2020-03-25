package tic_tac_toe.level;

import java.util.Map;
import java.util.Random;

public class Easy implements GameLevel {

    private Random random = new Random();

    @Override
    public int computerChoice(Map<Integer, String> board, String computerSymbol, String userSymbol) {
        int field;
        do {
            field = random.nextInt(9);
        } while (!board.get(field).equals(" "));
        return field;
    }
}
