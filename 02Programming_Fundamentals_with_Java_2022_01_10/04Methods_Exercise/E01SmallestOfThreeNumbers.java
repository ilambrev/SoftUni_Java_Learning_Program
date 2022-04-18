package E04Methods;

import java.util.Scanner;

public class E01SmallestOfThreeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        smallestNumber(firstNumber, secondNumber, thirdNumber);
    }

    public static void smallestNumber(int firstNumber, int secondNumber, int thirdNumber) {
        int minNumber = Integer.MAX_VALUE;
        if (firstNumber < minNumber) {
            minNumber = firstNumber;
        }
        if (secondNumber < minNumber) {
            minNumber = secondNumber;
        }
        if (thirdNumber < minNumber) {
            minNumber = thirdNumber;
        }
        System.out.println(minNumber);
    }

}