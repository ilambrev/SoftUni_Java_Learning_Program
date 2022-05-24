package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L01CompareMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = createMatrix(scanner);
        int[][] secondMatrix = createMatrix(scanner);

        System.out.println(compareMatrix(firstMatrix, secondMatrix) ? "equal" : "not equal");

    }

    private static int[][] createMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int columns = dimensions[1];

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static boolean compareMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            return false;
        } else {
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix[i].length; j++) {
                    if (firstMatrix[i][j] != secondMatrix[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}