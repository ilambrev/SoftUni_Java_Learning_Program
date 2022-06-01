package L02MultidimensionalArrays;

import java.util.Scanner;

public class L07FindTheRealQueen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[8][8];

        fillBoardWithFigures(scanner, board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'q') {
                    if (checkQueenPosition(board, i, j)) {
                        System.out.println(i + " " + j);
                        break;
                    }
                }
            }
        }
    }

    private static void fillBoardWithFigures(Scanner scanner, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            String row = scanner.nextLine();
            board[i] = row.replace(" ", "").trim().toCharArray();
        }
    }

    private static boolean checkQueenPosition(char[][] board, int row, int col) {
        boolean isRealQueen = true;
        int counter = 0;
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == 'q') {
                counter++;
            }
            if (counter > 1) {
                isRealQueen = false;
                break;
            }
        }
        if (isRealQueen) {
            counter = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][col] == 'q') {
                    counter++;
                }
                if (counter > 1) {
                    isRealQueen = false;
                    break;
                }
            }
        }
        if (isRealQueen) {
            counter = 0;
            int beginRowSubMatrix = Math.max(row - col, 0);
            int beginColSubMatrix = Math.max(col - row, 0);
            int endRowSubMatrix = Math.min(board[0].length - 1 - beginColSubMatrix, board.length - 1);
            for (int i = 0; i <= endRowSubMatrix - beginRowSubMatrix; i++) {
                if (board[beginRowSubMatrix + i][beginColSubMatrix + i] == 'q') {
                    counter++;
                }
                if (counter > 1) {
                    isRealQueen = false;
                    break;
                }
            }
        }
        if (isRealQueen) {
            counter = 0;
            int endRowSubMatrix = Math.min(row + col, board.length - 1);
            int endColSubMatrix = Math.max(col - (endRowSubMatrix - row), 0);
            int beginRowSubMatrix = Math.max(endRowSubMatrix - (board[0].length - 1) + endColSubMatrix, 0);
            int beginColSubMatrix = Math.min(endRowSubMatrix + endColSubMatrix, board.length - 1);
            for (int i = 0; i <= beginColSubMatrix - endColSubMatrix; i++) {
                if (board[beginRowSubMatrix + i][beginColSubMatrix - i] == 'q') {
                    counter++;
                }
                if (counter > 1) {
                    isRealQueen = false;
                    break;
                }
            }
        }

        return isRealQueen;
    }

}