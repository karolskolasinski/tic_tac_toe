package tic_tac_toe.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tic_tac_toe.model.Cell;
import tic_tac_toe.validator.GameValidator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GameTest {

    private Game game = new Game();
    private GameValidator gameValidator = new GameValidator();

    @BeforeEach
    void setup() {
        game.initializeBoard();
    }

    @Test
    void theNewGameShouldBeNotOver() {
        boolean status = gameValidator.isGameOver(game.getBoard(), 'X', 'O');

        assertThat(status, is(false));
    }

    @Test
    void theGameShouldBeOverWhenThereIsThreeSymbolsInARow() {
        gameValidator.placeAMove(game.getBoard(), new Cell(0, 0), 'X');
        gameValidator.placeAMove(game.getBoard(), new Cell(0, 1), 'X');
        gameValidator.placeAMove(game.getBoard(), new Cell(0, 2), 'X');

        boolean status = gameValidator.isGameOver(game.getBoard(), 'X', 'O');

        assertThat(status, is(true));
    }

}
