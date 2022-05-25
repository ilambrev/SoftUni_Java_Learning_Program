package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L05MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(matrixDimensions[0]);
        int columns = Integer.parseInt(matrixDimensions[1]);

        int[][] matrix = createMatrix(scanner, rows, columns);

        System.out.println(subMatrixMaxSum(matrix));

    }

    public static int[][] createMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static String subMatrixMaxSum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    result.setLength(0);
                    result.append(matrix[i][j]).append(" ").append(matrix[i][j + 1]).append(System.lineSeparator())
                            .append(matrix[i + 1][j]).append(" ").append(matrix[i + 1][j + 1]).append(System.lineSeparator())
                            .append(maxSum);
                }
            }
        }

        return result.toString();
    }

}