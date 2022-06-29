package L01WorkingWithAbstraction;

import java.util.Scanner;

public class L01RhombusOfStars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rhombusSize = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < rhombusSize * 2; i++) {
            printRow(rhombusSize, i);
        }

    }

    public static void printRow(int rhombusSize, int rowNumber) {

        if (rowNumber > rhombusSize) {
            rowNumber = rhombusSize - (rowNumber - rhombusSize);
        }

        for (int i = rhombusSize; i > rowNumber; i--) {
            System.out.print(" ");
        }

        for (int j = 1; j <= rowNumber; j++) {
            System.out.print("* ");
        }

        System.out.println();
    }

}