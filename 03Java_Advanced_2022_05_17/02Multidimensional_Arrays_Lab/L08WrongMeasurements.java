package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L08WrongMeasurements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = createMatrix(scanner);

        String[] coordinates = scanner.nextLine().split(" ");

        int row = Integer.parseInt(coordinates[0]);
        int col = Integer.parseInt(coordinates[1]);

        correctWrongValues(matrix, row, col);

        printMatrix(matrix);
    }

    private static int[][] createMatrix(Scanner scanner) {
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        return matrix;
    }

    private static void correctWrongValues(int[][] matrix, int row, int col) {
        int wrongValue = matrix[row][col];
        int[][] array = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == wrongValue) {
                    int newValue = (i - 1 >= 0 ? array[i - 1][j] != wrongValue ? array[i - 1][j] : 0 : 0)
                            + (i + 1 <= array.length - 1 ? array[i + 1][j] != wrongValue ? array[i + 1][j] : 0 : 0)
                            + (j - 1 >= 0 ? array[i][j - 1] != wrongValue ? array[i][j - 1] : 0 : 0)
                            + (j + 1 <= array[i].length - 1 ? array[i][j + 1] != wrongValue ? array[i][j + 1] : 0 : 0);
                    matrix[i][j] = newValue;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}