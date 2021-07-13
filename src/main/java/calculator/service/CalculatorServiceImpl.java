package calculator.service;

import calculator.exception.CalculatorException;
import org.apache.commons.lang3.math.NumberUtils;

public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public int add(String num1Text, String num2Text) {
        if (num1Text == null || num1Text.isEmpty()) {
            throw new CalculatorException("Num1 is required.");
        }

        if (num2Text == null || num2Text.isEmpty()) {
            throw new CalculatorException("Num2 is required.");
        }

        if (!NumberUtils.isParsable(num1Text)) {
            throw new CalculatorException("Num1 should be a number.");
        }

        if (!NumberUtils.isParsable(num2Text)) {
            throw new CalculatorException("Num2 should be a number.");
        }

        int num1 = Integer.parseInt(num1Text);
        if (num1 < 0) {
            throw new CalculatorException("Num1 should be greater than or equal to 0.");
        }

        int num2 = Integer.parseInt(num2Text);
        if (num2 < 0) {
            throw new CalculatorException("Num2 should be greater than or equal to 0.");
        }


        return num1 + num2;
    }
}
