package E02MultidimensionalArrays;

import java.util.Scanner;

public class E02MatrixOfPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] matrixDimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(matrixDimensions[0]);
        int cols = Integer.parseInt(matrixDimensions[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix);

        printMatrix(matrix);
    }

    private static void fillMatrix(String[][] matrix) {
        StringBuilder palindrome = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char firstSymbol = (char) (97 + i);
                char secondSymbol = (char) (97 + i + j);
                palindrome.append(firstSymbol).append(secondSymbol).append(firstSymbol);
                matrix[i][j] = palindrome.toString();
                palindrome.setLength(0);
            }
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

}