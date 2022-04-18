package E04Methods;

import java.util.Scanner;

public class E08FactorialDivision {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

            factorialsDivision(firstNumber, secondNumber);
    }

    public static void factorialsDivision(int firstNumber, int secondNumber) {
        double resultOfDivision = 0;
        resultOfDivision = numberFactorial(firstNumber) * 1.0 / numberFactorial(secondNumber);
        System.out.printf("%.2f", resultOfDivision);
    }

    public static long numberFactorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

}