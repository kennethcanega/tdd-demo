package calculator.service;

public class CalculatorPart2 {
    public int sum(String... nums) {
        int result = 0;
        for (String num : nums) {
            result += Integer.parseInt(num);
        }
        return result;
    }
}
