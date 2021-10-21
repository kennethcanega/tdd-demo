package calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CalculatorPart2Test {
    private CalculatorPart2 calculatorPart2;

    @BeforeEach
    void setUp() {
        calculatorPart2 = new CalculatorPart2();
    }

    @Test
    void sum_whenParamsIsOneAndTwo_thenReturnIntThree() {
        int result = calculatorPart2.sum("1", "2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void sum_whenParamsIsOneAndTwoAndThree_thenReturnIntSix() {
        int result = calculatorPart2.sum("1", "2", "3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void sum_whenParamsIsThreeAndFourAndFive_thenReturnIntTwelve() {
        int result = calculatorPart2.sum("3", "4", "5");
        assertThat(result).isEqualTo(12);
    }

    @Test
    void sum_whenParamsIsFourAndFiveAndSix_thenReturnIntFifteen() {
        int result = calculatorPart2.sum("4", "5", "6");
        assertThat(result).isEqualTo(15);
    }

    @Test
    void sum_whenParamsIsSixAndSevenAndEight_thenReturnTwentyOne() {
        int result = calculatorPart2.sum("6", "7", "8");
        assertThat(result).isEqualTo(21);
    }
}