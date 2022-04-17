package L04Methods;

import java.util.Scanner;

public class L10MultiplyEvensByOdds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(getMultipleOfEvensAndOdds(number));
    }

    public static int getMultipleOfEvensAndOdds(int number) {
        return sumOfEvenDigits(number) * sumOfOddDigits(number);
    }

    public static int sumOfEvenDigits(int number) {
        String[] numberArr = String.valueOf(number).split("");
        int sum = 0;
        for (int i = 0; i < numberArr.length; i++) {
            int digit = Integer.parseInt(numberArr[i]);
            if (digit % 2 == 0) {
                sum += digit;
            }
        }
        return sum;
    }

    public static int sumOfOddDigits(int number) {
        String[] numberArr = String.valueOf(number).split("");
        int sum = 0;
        for (int i = 0; i < numberArr.length; i++) {
            int digit = Integer.parseInt(numberArr[i]);
            if (digit % 2 != 0) {
                sum += digit;
            }
        }
        return sum;
    }

}