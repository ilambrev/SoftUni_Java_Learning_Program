package L03Arrays;

import java.util.Scanner;

public class L07CondenseArrayToNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        int[] numberArr = new int[inputArr.length];

        int startArrLength = numberArr.length;

        for (int i = 0; i < numberArr.length; i++) {
            numberArr[i] = Integer.parseInt(inputArr[i]);
        }
            while (startArrLength > 1) {
                startArrLength--;
                for (int i = 0; i < startArrLength; i++) {
                    numberArr[i] = numberArr[i] + numberArr[i + 1];
                }
            }
        System.out.println(numberArr[0]);
    }
}