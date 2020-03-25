package tic_tac_toe.level;

import java.util.Map;

public interface GameLevel {

    int computerChoice(Map<Integer, String> board, String computerSymbol, String userSymbol);
}
