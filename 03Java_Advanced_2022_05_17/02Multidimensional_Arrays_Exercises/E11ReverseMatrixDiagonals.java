package E02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E11ReverseMatrixDiagonals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixDimensions[0]);
        int cols = Integer.parseInt(matrixDimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            int beginCol = i < matrix.length - 1 ? 0 : matrix[0].length - 1;
            for (int j = beginCol; j >= 0; j--) {
                int diagonalLength = Math.min(matrix[0].length - j, i + 1);
                for (int k = 1; k <= diagonalLength; k++) {
                    System.out.print(matrix[i + 1 - k][j - 1 + k] + " ");
                }
                System.out.println();
            }
        }

    }
}