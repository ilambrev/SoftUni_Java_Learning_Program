package E02MultidimensionalArrays;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(matrixDimensions[0]);
        int cols = Integer.parseInt(matrixDimensions[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(scanner, matrix);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            if (isInputValid(command, rows, cols)) {
                String[] commandParams = command.split(" ");
                int row1 = Integer.parseInt(commandParams[1]);
                int col1 = Integer.parseInt(commandParams[2]);
                int row2 = Integer.parseInt(commandParams[3]);
                int col2 = Integer.parseInt(commandParams[4]);
                matrixShuffle(matrix, row1, col1, row2, col2);
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }

    }

    private static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
    }

    private static boolean isInputValid(String command, int rows, int cols) {
        Pattern pattern = Pattern.compile("^(?<command>swap) (?<row1>\\d+) (?<col1>\\d+) (?<row2>\\d+) (?<col2>\\d+)$");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            int row1 = Integer.parseInt(matcher.group("row1"));
            int col1 = Integer.parseInt(matcher.group("col1"));
            int row2 = Integer.parseInt(matcher.group("row2"));
            int col2 = Integer.parseInt(matcher.group("col2"));
            return row1 >= 0 && row1 <= rows && row2 >= 0 && row2 <= rows && col1 >= 0 && col1 <= cols && col2 >= 0 && col2 <= cols;
        } else {
            return false;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void matrixShuffle(String[][] matrix, int row1, int col1, int row2, int col2) {
        String buffer = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = buffer;
    }

}