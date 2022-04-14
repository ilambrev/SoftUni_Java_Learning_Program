package L03Arrays;

import java.util.Scanner;

public class L05EvenAndOddSubtraction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split(" ");

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            int currentElement = Integer.parseInt(inputArray[i]);
            if (currentElement % 2 == 0) {
                evenSum += currentElement;
            } else {
                oddSum += currentElement;
            }
        }
        System.out.println(evenSum - oddSum);
    }
}