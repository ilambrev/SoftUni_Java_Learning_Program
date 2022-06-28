package EX12Exam;

import java.util.Scanner;

public class EX02ReVolt {
    private static int playerRow;
    private static int playerCol;
    private static boolean finishReached = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int i = 0; i < matrix.length; i++) {
            String rowString = scanner.nextLine();
            for (int j = 0; j < rowString.length(); j++) {
                matrix[i][j] = rowString.charAt(j);
                if (matrix[i][j] == 'f') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        for (int i = 1; i <= numberOfCommands; i++) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    playerMove(matrix, -1, 0);
                    break;
                case "down":
                    playerMove(matrix, 1, 0);
                    break;
                case "left":
                    playerMove(matrix, 0, -1);
                    break;
                case "right":
                    playerMove(matrix, 0, 1);
                    break;
            }

            if (finishReached) {
                break;
            }

        }

        if (finishReached) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);

    }

    public static void playerMove(char[][] matrix, int rowModifier, int colModifier) {
        int nextRow = playerRow + rowModifier;
        int nextCol = playerCol + colModifier;

        boolean bonusHit = false;

        if (matrix[playerRow][playerCol] != 'B' && matrix[playerRow][playerCol] != 'T') {
            matrix[playerRow][playerCol] = '-';
        }

        if (nextRow < 0) {
            nextRow = matrix.length - 1;
        } else if (nextRow > matrix.length - 1) {
            nextRow = 0;
        } else if (nextCol < 0) {
            nextCol = matrix.length - 1;
        } else if (nextCol > matrix.length - 1) {
            nextCol = 0;
        }

        if (matrix[nextRow][nextCol] == 'F') {
            matrix[nextRow][nextCol] = 'f';
            finishReached = true;
        } else if (matrix[nextRow][nextCol] == 'T') {
            nextRow = playerRow;
            nextCol = playerCol;
        } else if (matrix[nextRow][nextCol] == 'B') {
            bonusHit = true;
        }

        if (matrix[nextRow][nextCol] != 'B' && matrix[nextRow][nextCol] != 'T' && matrix[nextRow][nextCol] != 'F') {
            matrix[nextRow][nextCol] = 'f';
        }
        playerRow = nextRow;
        playerCol = nextCol;

        if (bonusHit) {
            playerMove(matrix, rowModifier, colModifier);
        }

    }

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}