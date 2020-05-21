package tic_tac_toe.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tic_tac_toe.Messages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GameTest {

    private Messages messages = new Messages();
    private Game game = new Game(messages);

    @BeforeEach
    void setup() {
        game.initializeBoard();
    }

    @Test
    void endGameShouldBeFalse() {
//        boolean status = game.isGameOver();

//        assertThat(status, is(false));
    }

    @Test
    void endGameShouldBeTrue() {
//        game.applySymbol(0, "X");
//        game.applySymbol(1, "X");
//        game.applySymbol(2, "X");

//        boolean status = game.isGameOver();

//        assertThat(status, is(true));
    }

}
