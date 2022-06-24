package EX05RetakeExam;

import java.util.Scanner;

public class EX02FormulaOne {
    private static int playerRow;
    private static int playerCol;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        for (int i = 0; i < matrix.length; i++) {
            String rowString = scanner.nextLine();
            for (int j = 0; j < rowString.length(); j++) {
                matrix[i][j] = rowString.charAt(j);
                if (matrix[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        boolean finishReached = false;

        for (int i = 1; i <= numberOfCommands; i++) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    finishReached = playerMove(matrix, -1, 0);
                    break;
                case "down":
                    finishReached = playerMove(matrix, 1, 0);
                    break;
                case "left":
                    finishReached = playerMove(matrix, 0, -1);
                    break;
                case "right":
                    finishReached = playerMove(matrix, 0, 1);
                    break;
            }

            if (finishReached) {
                break;
            }

        }

        if (finishReached) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);

    }

    private static boolean playerMove(char[][] matrix, int rowModifier, int colModifier) {
        int nextRow = playerRow + rowModifier;
        int nextCol = playerCol + colModifier;

        boolean bonusHit = false;

        if (matrix[playerRow][playerCol] != 'B') {
            matrix[playerRow][playerCol] = '.';
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
            matrix[nextRow][nextCol] = 'P';
            playerRow = nextRow;
            playerCol = nextCol;
            return true;
        } else if (matrix[nextRow][nextCol] == 'B') {
            bonusHit = true;
        } else if (matrix[nextRow][nextCol] == 'T') {
            nextRow = playerRow;
            nextCol = playerCol;
        }

        if (bonusHit) {
            playerRow = nextRow;
            playerCol = nextCol;
            playerMove(matrix, rowModifier, colModifier);
        } else {
            matrix[nextRow][nextCol] = 'P';
            playerRow = nextRow;
            playerCol = nextCol;
        }

        return false;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}