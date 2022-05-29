package E02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E04MaximalSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(matrixDimensions[0]);
        int cols = Integer.parseInt(matrixDimensions[1]);

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, matrix);

        int[] subMatrixParameters = new int[3];

        findSubMatrixWithMaxElementsSum(matrix, subMatrixParameters);
        System.out.println("Sum = " + subMatrixParameters[0]);
        printSubMatrix(matrix, subMatrixParameters[1], subMatrixParameters[2]);
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static void findSubMatrixWithMaxElementsSum(int[][] matrix, int[] subMatrixParameters) {
        int maxSum = Integer.MIN_VALUE;
        int rowIndex = -1;
        int colIndex = -1;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }

        subMatrixParameters[0] = maxSum;
        subMatrixParameters[1] = rowIndex;
        subMatrixParameters[2] = colIndex;
    }

    private static void printSubMatrix(int[][] matrix, int rowIndex, int colIndex) {
        for (int i = rowIndex; i < rowIndex + 3; i++) {
            for (int j = colIndex; j < colIndex + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}