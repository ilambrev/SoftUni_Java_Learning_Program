package e04ForLoop;

import java.util.Scanner;

public class E02HalfSumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int maxNum = Integer.MIN_VALUE;
        int numberSum = 0;

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number > maxNum) {
                maxNum = number;
            }
            numberSum = numberSum + number;
        }
        numberSum = numberSum - maxNum;
        if (maxNum == numberSum) {
            System.out.printf("Yes%nSum = %d", numberSum);
        } else {
            System.out.printf("No%nDiff = %d", Math.abs(numberSum - maxNum));
        }
    }
}