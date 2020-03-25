package tic_tac_toe.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tic_tac_toe.Messages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class BoardControllerTest {

    private Messages messages = new Messages();
    private BoardController boardController = new BoardController(messages);

    @BeforeEach
    void setup() {
        boardController.initializeBoard();
    }

    @Test
    void endGameShouldBeFalse() {
        boolean status = boardController.gameStatus();

        assertThat(status, equalTo(false));
    }

    @Test
    void endGameShouldBeTrue() {
        boardController.applySymbol(0, "X");
        boardController.applySymbol(1, "X");
        boardController.applySymbol(2, "X");

        boolean status = boardController.gameStatus();

        assertThat(status, equalTo(true));
    }

}
