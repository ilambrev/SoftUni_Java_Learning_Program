package ME04Methods;

import java.util.Scanner;

public class ME04TribonacciSequence {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());

        int[] sequence = new int[numbers + 2];
        sequence[2] = 1;

        findSequence(sequence);
        printSequence(sequence);

    }

    private static void findSequence(int[] sequence) {
            for (int i = 3; i < sequence.length; i++) {
                sequence[i] = sequence[i - 1] + sequence[i - 2] + sequence[i - 3];
            }
    }

    private static void printSequence(int[] sequence) {
        for (int i = 2; i < sequence.length; i++) {
            System.out.print(sequence[i]);
            if (i < sequence.length - 1) {
                System.out.print(" ");
            }
        }
    }

}