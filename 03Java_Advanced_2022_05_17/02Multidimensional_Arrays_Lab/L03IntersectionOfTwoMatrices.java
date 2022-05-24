package L02MultidimensionalArrays;

import java.util.Scanner;

public class L03IntersectionOfTwoMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = createMatrix(scanner, rows, columns);
        char[][] secondMatrix = createMatrix(scanner, rows, columns);

        intersectMatrix(firstMatrix, secondMatrix);
    }

    private static char[][] createMatrix(Scanner scanner, int rows, int columns) {
        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            String[] row = scanner.nextLine().split(" ");
            char[] newRow = new char[row.length];
            for (int j = 0; j < newRow.length; j++) {
                newRow[j] = row[j].charAt(0);
            }
            matrix[i] = newRow;
        }

        return matrix;
    }

    private static void intersectMatrix(char[][] firstMatrix, char[][] secondMatrix) {
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    System.out.print(firstMatrix[i][j] + " ");
                } else {
                    System.out.print('*' + " ");
                }
            }
            System.out.println();
        }
    }

}