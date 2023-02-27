package E2021_11_13;

import java.util.Scanner;

public class P06MultiplyTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scanner.nextLine());

        int thirdDigit = inputNumber % 10;
        int secondDigit = (inputNumber / 10) % 10;
        int firstDigit = (inputNumber / 100) % 10;

        for (int i = 1; i <= thirdDigit; i++) {
            for (int j = 1; j <= secondDigit; j++) {
                for (int k = 1; k <= firstDigit; k++) {
                    System.out.printf("%d * %d * %d = %d;%n", i, j, k, i * j * k);
                }
            }
        }
    }
}