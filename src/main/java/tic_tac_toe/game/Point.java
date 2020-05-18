package tic_tac_toe.game;

import lombok.Data;

@Data
public class Point {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
