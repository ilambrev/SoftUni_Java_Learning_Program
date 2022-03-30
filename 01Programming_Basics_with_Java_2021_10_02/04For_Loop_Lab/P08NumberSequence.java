package forLoop;

import java.util.Scanner;

public class P08NumberSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;

        for (int i = 1; i <= num; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            if (n > maxNumber) {
                maxNumber = n;
            }
            if (n < minNumber) {
                minNumber = n;
            }
        }
        System.out.printf("Max number: %d%n", maxNumber);
        System.out.printf("Min number: %d%n", minNumber);
    }
}