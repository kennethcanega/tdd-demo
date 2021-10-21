package calculator.service;

import calculator.exception.CalculatorException;

public class DemoServiceImpl implements DemoService {
    @Override
    public int calculatePow(String base, String exponent) {
        validateParams(base, exponent);
        int baseNum = Integer.parseInt(base);
        int exponentNum = Integer.parseInt(exponent);
        int ans = 1;
        for (int i = 1; i <= exponentNum; i++) {
            ans *= baseNum;
        }
        return ans;
    }

    public void validateParams(String base, String exponent) {
        if (base == null || base.isEmpty()) {
            throw new CalculatorException("Base must not be null or empty.");
        }
        if (exponent == null || exponent.isEmpty()) {
            throw new CalculatorException("Exponent must not be null or empty.");
        }
    }
}
