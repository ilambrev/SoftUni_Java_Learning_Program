package E02MultidimensionalArrays;

import java.util.Scanner;

public class E01FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputParameters = scanner.nextLine().split(", ");

        int matrixSize = Integer.parseInt(inputParameters[0]);
        String fillPattern = inputParameters[1];
        int[][] matrix = new int[matrixSize][matrixSize];

        switch (fillPattern) {
            case "A":
                patternA(matrix);
                break;
            case "B":
                patternB(matrix);
                break;
        }

        printMatrix(matrix);
    }

    private static void patternA(int[][] matrix) {
        int counter = 1;
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = counter;
                counter++;
            }
        }
    }

    private static void patternB(int[][] matrix) {
        int counter = 1;
        for (int j = 0; j < matrix[0].length; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = counter;
                    counter++;
                }
            } else {
                for (int i = matrix.length - 1; i >= 0; i--) {
                    matrix[i][j] = counter;
                    counter++;
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