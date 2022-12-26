package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.Calculator.CALCULATOR;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    @DisplayName("Testing Calculator with valid Responses")
    @ParameterizedTest(name = "{index} Performing {0} on num1=''{1}'' AND num2=''{2}''")
    @MethodSource("validData")
    void shouldReturnValidResults(Operations operations,Double num1,Double num2,Double expectedAnswer) {
        Double actualAnswer = CALCULATOR.calculate(operations, num1, num2);
        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    private static Stream<Arguments> validData(){
        return Stream.of(
                Arguments.arguments(Operations.ADD,0.0,0.0,0.0),
                Arguments.arguments(Operations.ADD,2.0,3.0,5.0),
                Arguments.arguments(Operations.ADD,3.0,2.0,5.0),
                Arguments.arguments(Operations.SUB,0.0,0.0,0.0),
                Arguments.arguments(Operations.SUB,3.0,2.0,1.0),
                Arguments.arguments(Operations.SUB,2.0,3.0,-1.0),
                Arguments.arguments(Operations.MUL,2.0,3.0,6.0),
                Arguments.arguments(Operations.MUL,3.0,2.0,6.0),
                Arguments.arguments(Operations.DIV,2.0,4.0,0.5),
                Arguments.arguments(Operations.DIV,4.0,2.0,2.0)
        );
    }

    @DisplayName("Testing Calculator with invalid Responses")
    @ParameterizedTest(name = "{index} Expecting ArithmeticException with errorMessage=''{3}'' on Performing {0} on num1=''{1}'' AND num2=''{2}''")
    @MethodSource("invalidData")
    void shouldReturnResultForInvalidDataInfinity(Operations operations,Double num1,Double num2,String errorMsg) {
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> CALCULATOR.calculate(operations, num1, num2));
        assertTrue(arithmeticException.getMessage().contentEquals(errorMsg));
    }

    public static Stream<Arguments> invalidData() {
        return Stream.of(
                Arguments.arguments(Operations.MUL,Double.MAX_VALUE,Double.MAX_VALUE,"Positive/Negative Infinity Occurred: Calculator doesn't support such numbers"),
                Arguments.arguments(Operations.DIV,1.0,0.0,"Positive/Negative Infinity Occurred: Calculator doesn't support such numbers"),
                Arguments.arguments(Operations.DIV,-1.0,0.0,"Positive/Negative Infinity Occurred: Calculator doesn't support such numbers"),
                Arguments.arguments(Operations.DIV,0.0,0.0,"Result is NaN: Calculator doesn't support such numbers"),
                Arguments.arguments(Operations.ADD,Double.MAX_VALUE,Double.MAX_VALUE,"Positive/Negative Infinity Occurred: Calculator doesn't support such numbers")
        );
    }
}