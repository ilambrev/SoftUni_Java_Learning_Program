package L04Methods;

import java.util.Scanner;

public class L04Calculations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String calculationType = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        switch (calculationType) {
            case "add":
                addCalculation(firstNumber, secondNumber);
                break;
            case "multiply":
                multiplyCalculation(firstNumber, secondNumber);
                break;
            case "subtract":
                subtractCalculation(firstNumber, secondNumber);
                break;
            case "divide":
                divideCalculation(firstNumber, secondNumber);
                break;
        }

    }

    public static void addCalculation(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        System.out.println(result);
    }

    public static void multiplyCalculation(int firstNumber, int secondNumber) {
        int result = firstNumber * secondNumber;
        System.out.println(result);
    }

    public static void subtractCalculation(int firstNumber, int secondNumber) {
        int result = firstNumber - secondNumber;
        System.out.println(result);
    }

    public static void divideCalculation(int firstNumber, int secondNumber) {
        int result = firstNumber / secondNumber;
        System.out.println(result);
    }

}