package calculator.service;

import calculator.exception.CalculatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceImplTest {
    private CalculatorService calculatorService;

    /*
        test scenarios:
            when either num1 or num2 is empty, throw exception                  => done
            when either num1 or num2 has non numeric input, throw exception     => done
            when num1 or num2 less than 0, throw exception                      => done
            when num1 + num2 should return correct result:                      => done
                0 + 0       = 0
                1 + 2       = 3
                4 + 4       = 8
                16 + 16     = 32
                7 + 7       = 14
                100 + 100   = 200
                90 + 90     = 180
        if
    * */
    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    private static int[][] getValidSamples() {
        return new int[][]{
                {0, 0, 0},
                {1, 2, 3},
                {4, 4, 8},
                {16, 16, 32},
                {7, 7, 14},
                {100, 100, 200},
                {90, 90, 180}
        };
    }

    @Test
    void add_whenNum1IsNull_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> calculatorService.add(null, "3"),
                "Num1 is required."
        );
        assertThat(thrown.getMessage()).isEqualTo("Num1 is required.");
    }

    @Test
    void add_whenNum1IsBlank_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> calculatorService.add("", "3"),
                "Num1 is required."
        );
        assertThat(thrown.getMessage()).isEqualTo("Num1 is required.");
    }

    @Test
    void add_whenNum2IsNull_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> calculatorService.add("3", null),
                "Num2 is required."
        );
        assertThat(thrown.getMessage()).isEqualTo("Num2 is required.");
    }

    @Test
    void add_whenNum2IsBlank_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> calculatorService.add("3", ""),
                "Num2 is required."
        );
        assertThat(thrown.getMessage()).isEqualTo("Num2 is required.");
    }

    @Test
    void add_whenNum1IsNotANumber_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> calculatorService.add("test", "3"),
                "Num1 should be a number."
        );
        assertThat(thrown.getMessage()).isEqualTo("Num1 should be a number.");
    }

    @Test
    void add_whenNum2IsNotANumber_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> calculatorService.add("3", "test"),
                "Num2 should be a number."
        );
        assertThat(thrown.getMessage()).isEqualTo("Num2 should be a number.");
    }

    @Test
    void add_whenNum1IsLessThanZero_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> calculatorService.add("-3", "10"),
                "Num1 should be greater than or equal to 0."
        );
        assertThat(thrown.getMessage()).isEqualTo("Num1 should be greater than or equal to 0.");
    }

    @Test
    void add_whenNum2IsLessThanZero_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> calculatorService.add("3", "-3"),
                "Num2 should be greater than or equal to 0."
        );
        assertThat(thrown.getMessage()).isEqualTo("Num2 should be greater than or equal to 0.");
    }

    @ParameterizedTest
    @MethodSource("getValidSamples")
    void add_whenValidNum1AndValidNum2_thenReturnCorrectResult(int[] num1Num2AndResult) {
        int result = calculatorService.add(Integer.toString(num1Num2AndResult[0]), Integer.toString(num1Num2AndResult[1]));
        assertThat(result).isEqualTo(num1Num2AndResult[2]);
    }
}