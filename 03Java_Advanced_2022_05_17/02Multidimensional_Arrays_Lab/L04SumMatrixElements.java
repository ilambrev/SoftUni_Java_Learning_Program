package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L04SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(matrixDimensions[0]);
        int columns = Integer.parseInt(matrixDimensions[1]);

        int[][] matrix = createMatrix(scanner, rows, columns);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(matrixElementsSum(matrix));

    }

    private static int[][] createMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static int matrixElementsSum(int[][] matrix) {
        int sumOfElements = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sumOfElements += matrix[i][j];
            }
        }

        return sumOfElements;
    }

}