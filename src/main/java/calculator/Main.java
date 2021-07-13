package calculator;

import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorService service = new CalculatorServiceImpl();
        System.out.println("Enter num1:");
        String numText1 = scanner.next();
        System.out.println("Enter num2:");
        String numText2 = scanner.next();

        System.out.println("Answer is: " + service.add(numText1, numText2));
    }
}
