package L03Arrays;

import java.util.Scanner;

public class L05EvenAndOddSubtractionV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split(" ");

        int evenSum = 0;
        int oddSum = 0;

        for (String s : inputArray) {
            int currentElement = Integer.parseInt(s);
            if (currentElement % 2 == 0) {
                evenSum += currentElement;
            } else {
                oddSum += currentElement;
            }
        }
        System.out.println(evenSum - oddSum);
    }
}