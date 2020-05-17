package tic_tac_toe.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tic_tac_toe.Messages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class BoardTest {

    private Messages messages = new Messages();
    private Board board = new Board(messages);

    @BeforeEach
    void setup() {
        board.initializeBoard();
    }

    @Test
    void endGameShouldBeFalse() {
        boolean status = board.gameStatus();

        assertThat(status, is(false));
    }

    @Test
    void endGameShouldBeTrue() {
        board.applySymbol(0, "X");
        board.applySymbol(1, "X");
        board.applySymbol(2, "X");

        boolean status = board.gameStatus();

        assertThat(status, is(true));
    }

}
