package E03Arrays;

import java.util.Scanner;

public class E06EqualSums {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        int[] numberArr = new int[inputArr.length];

        int leftSum = 0;
        int rightSum = 0;
        boolean isElement = true;

        for (int i = 0; i < numberArr.length; i++) {
            numberArr[i] = Integer.parseInt(inputArr[i]);
        }
        for (int i = 0; i < numberArr.length; i++) {
            for (int j = i + 1; j < numberArr.length; j++) {
                rightSum += numberArr[j];
            }
            for (int k = i - 1; k >= 0; k--) {
                leftSum += numberArr[k];
            }
            if (rightSum == leftSum) {
                System.out.println(i);
                isElement = false;
            }
            leftSum = 0;
            rightSum = 0;
        }
        if (isElement) {
            System.out.println("no");
        }
    }
}