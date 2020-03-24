package tic_tac_toe.level;

import tic_tac_toe.controller.GameLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hard implements GameLevel {

    @Override
    public int computerChoice(Map<Integer, String> board, String computerSymbol, String userSymbol) {
        List<Integer> fields = new ArrayList<>();

        if (board.get(4).equals(" ")) {
            return 4;
        }

        /*ATTACK*/
        checkAllLines(board, computerSymbol, fields);

        /*DEFENSE*/
        checkAllLines(board, userSymbol, fields);

        for (Integer field : fields) {
            if (field > 0 && board.get(field).equals(" ")) {
                return field;
            }
        }

        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).equals(" ")) {
                return i;
            }
        }

        return -1;
    }

    private void checkAllLines(Map<Integer, String> board, String symbol, List<Integer> fields) {
        /*horizontal*/
        fields.add(checkLine(0, 1, 2, board, symbol));
        fields.add(checkLine(3, 4, 5, board, symbol));
        fields.add(checkLine(6, 7, 8, board, symbol));

        /*vertical*/
        fields.add(checkLine(0, 3, 6, board, symbol));
        fields.add(checkLine(1, 4, 7, board, symbol));
        fields.add(checkLine(2, 5, 8, board, symbol));

        /*diagonal*/
        fields.add(checkLine(0, 4, 8, board, symbol));
        fields.add(checkLine(2, 4, 6, board, symbol));
    }

    private int checkLine(int a, int b, int c, Map<Integer, String> board, String symbol) {
        String s1 = board.get(a);
        String s2 = board.get(b);
        String s3 = board.get(c);

        if (s1.equals(symbol) && s2.equals(symbol)) {
            return c;
        } else if (s1.equals(symbol) && s3.equals(symbol)) {
            return b;
        } else if (s2.equals(symbol) && s3.equals(symbol)) {
            return a;
        }

        return -1;
    }

}
