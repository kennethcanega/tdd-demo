package calculator.service;

import java.util.Arrays;

public class CalculatorPart2 {
    public int sum(String... nums) {
        return Arrays.stream(nums)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
