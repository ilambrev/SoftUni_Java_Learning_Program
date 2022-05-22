package Softuniada2022;

import java.util.Scanner;

public class SU03SortedArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfElements = scanner.nextInt();
        int[] numbers = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < numberOfElements - 1; i++) {
            if (i % 2 == 0) {
                if (numbers[i] < numbers[i + 1]) {
                    int numberOnEvenPosition = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = numberOnEvenPosition;
                }
            } else {
                if (numbers[i] > numbers[i + 1]) {
                    int numberOnOddPosition = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = numberOnOddPosition;
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}