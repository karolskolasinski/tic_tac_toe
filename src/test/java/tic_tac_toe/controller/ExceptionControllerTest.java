package tic_tac_toe.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionControllerTest {

    private ExceptionController exceptionController = new ExceptionController();

    @ParameterizedTest
    @MethodSource("wrongSymbol")
    void exceptionShouldBeThrownIfUserProvidedWrongSymbol(String symbol) {
        assertThrows(IllegalArgumentException.class, () -> exceptionController.wrongSymbolSelected(symbol));
    }

    private static Stream<Arguments> wrongSymbol() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("a"),
                Arguments.of("A"),
                Arguments.of("bb"),
                Arguments.of("BB")
        );
    }

    @ParameterizedTest
    @MethodSource("wrongLevel")
    void exceptionShouldBeThrownIfUserChosenWrongLevel(String level) {
        assertThrows(IllegalArgumentException.class, () -> exceptionController.wrongLevelSelected(level));
    }

    private static Stream<Arguments> wrongLevel() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("4"),
                Arguments.of("55")
        );
    }

    @ParameterizedTest
    @MethodSource("wrongAnswer")
    void exceptionShouldBeThrownWhenWrongPlayAgainAnswerSelected(String answer) {
        assertThrows(IllegalArgumentException.class, () -> exceptionController.wrongPlayAgainAnswerSelected(answer));
    }

    private static Stream<Arguments> wrongAnswer() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("a"),
                Arguments.of("aa"),
                Arguments.of("aaa"),
                Arguments.of("aaaa")
        );
    }

    @ParameterizedTest
    @MethodSource("wrongFieldNumber")
    void exceptionShouldBeThrownWhenWrongFieldNumberSelected(String field) {
        assertThrows(IllegalArgumentException.class, () -> exceptionController.wrongFieldNumberSelected(field));
    }

    private static Stream<Arguments> wrongFieldNumber() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("0"),
                Arguments.of("12"),
                Arguments.of("123")
        );
    }

    @ParameterizedTest
    @MethodSource("selectedField")
    void exceptionShouldBeThrownWhenChosenFieldIsAlreadySelected(int field) {
        Map<Integer, String> board = new HashMap<>(9);

        for (int i = 0; i < 9; i++) {
            board.put(i, " ");
        }

        board.replace(0, "X");
        board.replace(1, "O");

        assertThrows(IllegalArgumentException.class, () -> exceptionController.chosenFieldIsAlreadySelected(board, field));
    }

    private static Stream<Arguments> selectedField() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(1)
        );
    }


}
