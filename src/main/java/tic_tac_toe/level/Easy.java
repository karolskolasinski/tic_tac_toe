package tic_tac_toe.level;

import tic_tac_toe.controller.GameLevel;

import java.util.Map;
import java.util.Random;

public class Easy implements GameLevel {

    private Random random = new Random();

    @Override
    public int computerChoice(Map<Integer, String> board) {
        int field;
        do {
            field = random.nextInt(9);
        } while (!board.get(field).equals(" "));
        return field;
    }
}
