package calculator.service;

import calculator.exception.CalculatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DemoServiceTest {
    private DemoService demoService;

    private static int[][] getValidSamples() {
        return new int[][]{
                {10, 2, 100},
                {9, 2, 81},
                {3, 3, 27},
                {4, 2, 16},
                {9, 5, 59049},
                {7, 4, 2401},
                {2, 11, 2048}
        };
    }

    @BeforeEach
    void setUp() {
        demoService = new DemoServiceImpl();

        /*
        base and exponent must not be null or empty         =>  done
        base and exponent must be numeric
        base and exponent must be a positive integer
        base must not be equal to 0
        base raise to 1 = base
       */
    }

    @Test
    void calculatePow_whenBaseIsNull_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> demoService.calculatePow(null, "2")
        );
        assertThat(thrown.getMessage()).isEqualTo("Base must not be null or empty.");
    }

    @Test
    void calculatePow_whenBaseIsBlank_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> demoService.calculatePow("", "2")
        );
        assertThat(thrown.getMessage()).isEqualTo("Base must not be null or empty.");
    }

    @Test
    void calculatePow_whenExponentIsNull_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> demoService.calculatePow("9", null)
        );
        assertThat(thrown.getMessage()).isEqualTo("Exponent must not be null or empty.");
    }

    @Test
    void calculatePow_whenExponentIsBlank_thenThrowException() {
        CalculatorException thrown = assertThrows(
                CalculatorException.class,
                () -> demoService.calculatePow("9", "")
        );
        assertThat(thrown.getMessage()).isEqualTo("Exponent must not be null or empty.");
    }

    @Test
    void calculatePow_whenBaseIsNineAndExponentIsTwo_thenReturn81() {
        int result = demoService.calculatePow("9", "2");
        assertThat(result).isEqualTo(81);
    }

    @Test
    void calculatePow_whenBaseIsTenAndExponentIsTwo_thenReturn100() {
        int result = demoService.calculatePow("10", "2");
        assertThat(result).isEqualTo(100);
    }


    @ParameterizedTest
    @MethodSource("getValidSamples")
    void calculatePow_whenBaseIsValidAndExponentIsValid_thenReturnCorrectResult(int[] baseExponentResult) {
        int result = demoService.calculatePow(
                Integer.toString(baseExponentResult[0]),
                Integer.toString(baseExponentResult[1])
        );
        assertThat(result).isEqualTo(baseExponentResult[2]);
    }
}