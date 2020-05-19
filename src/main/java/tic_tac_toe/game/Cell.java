package tic_tac_toe.game;

import lombok.Data;

@Data
public
class Cell {

    private int x;
    private int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
