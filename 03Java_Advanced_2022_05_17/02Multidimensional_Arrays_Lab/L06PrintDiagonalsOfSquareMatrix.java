package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }

        System.out.println();

        for (int i = matrix.length - 1; i >= 0; i--) {
            System.out.print(matrix[i][matrix.length - 1 - i] + " ");
        }

    }
}