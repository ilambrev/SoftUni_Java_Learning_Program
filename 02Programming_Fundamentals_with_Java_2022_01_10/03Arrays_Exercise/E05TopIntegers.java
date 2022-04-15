package E03Arrays;

import java.util.Scanner;

public class E05TopIntegers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");
        int[] numberArr = new int[inputArr.length];

        boolean isTopInteger = true;

        for (int i = 0; i < inputArr.length; i++) {
            numberArr[i] = Integer.parseInt(inputArr[i]);
        }
        for (int i = 0; i < numberArr.length; i++) {
            for (int j = i + 1; j < numberArr.length; j++) {
                if (numberArr[j] >= numberArr[i]) {
                    isTopInteger = false;
                    break;
                }
            }
            if (isTopInteger) {
                System.out.print(numberArr[i] + " ");
            }
            isTopInteger = true;
        }
    }
}