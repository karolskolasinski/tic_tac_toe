package tic_tac_toe.model;

import lombok.Data;

@Data
public
class Cell {

    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
