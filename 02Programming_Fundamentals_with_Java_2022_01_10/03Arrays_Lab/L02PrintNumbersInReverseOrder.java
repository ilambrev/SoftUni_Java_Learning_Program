package L03Arrays;

import java.util.Scanner;

public class L02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int[] numberHolder = new int[number];

        for (int i = 0; i < number; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            numberHolder[i] = currentNumber;
        }

        for (int j = numberHolder.length - 1; j >= 0; j--) {
            System.out.print(numberHolder[j] + " ");
        }
    }
}