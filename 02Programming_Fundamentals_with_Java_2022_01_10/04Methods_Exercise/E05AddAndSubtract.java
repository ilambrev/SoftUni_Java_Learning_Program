package E04Methods;

import java.util.Scanner;

public class E05AddAndSubtract {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        System.out.println(subtract(firstNumber, secondNumber, thirdNumber));
    }

    public static int subtract(int firstNumber, int secondNumber, int thirdNumber) {
        return sum(firstNumber, secondNumber) - thirdNumber;
    }

    public static int sum(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

}