package E02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E07Crossfire {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] matrix = createMatrix(scanner);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            String[] attackParams = command.split(" ");
            int row = Integer.parseInt(attackParams[0]);
            int col = Integer.parseInt(attackParams[1]);
            int radius = Integer.parseInt(attackParams[2]);
            destroyTarget(matrix, row, col, radius);
            shiftDestroyedTargets(matrix);
            command = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static String[][] createMatrix(Scanner scanner) {
        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];

        String[][] matrix = new String[rows][cols];
        int counter = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.valueOf(counter);
                counter++;
            }
        }

        return matrix;
    }

    private static void destroyTarget(String[][] matrix, int row, int col, int radius) {
        int upRow = Math.max(row - radius, 0);
        int downRow = Math.min(row + radius, matrix.length - 1);
        int leftCol = Math.max(col - radius, 0);
        int rightCol = Math.min(col + radius, matrix[0].length - 1);

        if (col >= 0 && col < matrix.length) {
            for (int i = upRow; i <= downRow; i++) {
                matrix[i][col] = "";
            }
        }
        if (row >= 0 && row < matrix.length) {
            for (int i = leftCol; i <= rightCol; i++) {
                matrix[row][i] = "";
            }
        }
    }

    private static void shiftDestroyedTargets(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
            while (j < matrix[i].length - 1) {
                if (matrix[i][j].equals("") && !matrix[i][j + 1].equals("")) {
                    matrix[i][j] = matrix[i][j + 1];
                    matrix[i][j + 1] = "";
                    j = 0;
                } else {
                    j++;
                }
            }
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            if (matrix[i][0].equals("")) {
                String[] bufferArray = matrix[i];
                matrix[i] = matrix[i + 1];
                matrix[i + 1] = bufferArray;
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int emptyCellsCounter = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (!matrix[i][j].equals("")) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    emptyCellsCounter++;
                }
            }
            if (emptyCellsCounter < matrix[0].length) {
                System.out.println();
            }
        }
    }

}