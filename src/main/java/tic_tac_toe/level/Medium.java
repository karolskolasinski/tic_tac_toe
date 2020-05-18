package tic_tac_toe.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Medium implements GameLevel {

    @Override
    public int placeSymbol(Map<Integer, String> board, String computerSymbol, String userSymbol) {
        List<Integer> fields = new ArrayList<>();

        /*horizontal*/
        fields.add(checkLine(0, 1, 2, board, computerSymbol, userSymbol));
        fields.add(checkLine(3, 4, 5, board, computerSymbol, userSymbol));
        fields.add(checkLine(6, 7, 8, board, computerSymbol, userSymbol));

        /*vertical*/
        fields.add(checkLine(0, 3, 6, board, computerSymbol, userSymbol));
        fields.add(checkLine(1, 4, 7, board, computerSymbol, userSymbol));
        fields.add(checkLine(2, 5, 8, board, computerSymbol, userSymbol));

        /*diagonal*/
        fields.add(checkLine(0, 4, 8, board, computerSymbol, userSymbol));
        fields.add(checkLine(2, 4, 6, board, computerSymbol, userSymbol));

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

    private int checkLine(int a, int b, int c, Map<Integer, String> board, String computerSymbol, String userSymbol) {
        String s1 = board.get(a);
        String s2 = board.get(b);
        String s3 = board.get(c);
        if (s1.equals(computerSymbol) && s2.equals(computerSymbol)) {
            return c;
        } else if (s1.equals(computerSymbol) && s3.equals(computerSymbol)) {
            return b;
        } else if (s2.equals(computerSymbol) && s3.equals(computerSymbol)) {
            return a;
        } else if (s1.equals(userSymbol) && s2.equals(userSymbol)) {
            return c;
        } else if (s1.equals(userSymbol) && s3.equals(userSymbol)) {
            return b;
        } else if (s2.equals(userSymbol) && s3.equals(userSymbol)) {
            return a;
        }
        return -1;
    }
}
