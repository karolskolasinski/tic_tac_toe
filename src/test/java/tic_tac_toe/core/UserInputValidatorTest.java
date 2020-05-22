package tic_tac_toe.core;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tic_tac_toe.validator.InputValidator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInputValidatorTest {

    private InputValidator userInputValidator = new InputValidator();

    @ParameterizedTest
    @MethodSource("wrongSymbol")
    void exceptionShouldBeThrownIfUserProvidedWrongSymbol(String symbol) {
        assertThrows(IllegalArgumentException.class, () -> userInputValidator.validateSelectedSymbol(symbol));
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
        assertThrows(IllegalArgumentException.class, () -> userInputValidator.validateSelectedLevel(level));
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
        assertThrows(IllegalArgumentException.class, () -> userInputValidator.validatePlayAgainAnswer(answer));
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
        assertThrows(IllegalArgumentException.class, () -> userInputValidator.validateTakenFieldNumber(field));
    }

    private static Stream<Arguments> wrongFieldNumber() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("-1"),
                Arguments.of("-0"),
                Arguments.of("0"),
                Arguments.of("10"),
                Arguments.of("123")
        );
    }

}
