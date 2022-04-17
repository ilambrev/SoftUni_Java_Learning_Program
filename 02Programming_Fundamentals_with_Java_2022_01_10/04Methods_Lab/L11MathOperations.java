package L04Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class L11MathOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.##").format(calculation(firstNumber, operator, secondNumber)));
    }

    public static double calculation(int firstNumber, String operator, int secondNumber) {
        double result = 0.0;
        switch (operator) {
            case "/":
                result = firstNumber * 1.0 / secondNumber;
                break;
            case "*":
                result = firstNumber * 1.0 * secondNumber;
                break;
            case "+":
                result = firstNumber * 1.0 + secondNumber;
                break;
            case "-":
                result = firstNumber * 1.0 - secondNumber;
                break;
        }
        return result;
    }

}