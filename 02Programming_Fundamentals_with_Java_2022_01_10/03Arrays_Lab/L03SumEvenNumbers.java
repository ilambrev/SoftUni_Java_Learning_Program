package L03Arrays;

import java.util.Scanner;

public class L03SumEvenNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] numbersArr = new int[input.length];
        int sumEvenNumbers = 0;

        for (int i = 0; i < numbersArr.length; i++) {
            numbersArr[i] = Integer.parseInt(input[i]);
            if (numbersArr[i] % 2 == 0) {
                sumEvenNumbers += numbersArr[i];
            }
        }
        System.out.println(sumEvenNumbers);
    }
}