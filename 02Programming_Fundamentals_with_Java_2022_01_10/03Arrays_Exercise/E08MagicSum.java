package E03Arrays;

import java.util.Scanner;

public class E08MagicSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");
        int magicSum = Integer.parseInt(scanner.nextLine());

        int[] numberArr = new int[inputArr.length];

        for (int i = 0; i < inputArr.length; i++) {
            numberArr[i] = Integer.parseInt(inputArr[i]);
        }
        for (int i = 0; i < numberArr.length - 1; i++) {
            for (int j = i; j < numberArr.length - 1; j++) {
                if (numberArr[i] + numberArr[j + 1] == magicSum) {
                    System.out.println(numberArr[i] + " " + numberArr[j + 1]);
                }
            }
        }
    }
}