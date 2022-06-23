package EX02Exam;

import java.util.Scanner;

public class EX02PawnWars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[8][8];

        initialBoardState(board, scanner);

        int[] whitePawnCoordinates = {-1, -1};
        int[] blackPawnCoordinates = {-1, -1};

        findCoordinates(board, whitePawnCoordinates, 'w');
        findCoordinates(board, blackPawnCoordinates, 'b');

        int turnCounter = 1;

        boolean capture = false;

        while (whitePawnCoordinates[0] > 0 && blackPawnCoordinates[0] < 7) {
            if (turnCounter % 2 != 0) {
                if (blackPawnCoordinates[0] == whitePawnCoordinates[0] - 1 &&
                        (blackPawnCoordinates[1] == whitePawnCoordinates[1] + 1 ||
                                blackPawnCoordinates[1] == whitePawnCoordinates[1] - 1)) {
                    board[whitePawnCoordinates[0]][whitePawnCoordinates[1]] = '-';
                    whitePawnCoordinates[0] = blackPawnCoordinates[0];
                    whitePawnCoordinates[1] = blackPawnCoordinates[1];
                    board[whitePawnCoordinates[0]][whitePawnCoordinates[1]] = 'w';
                    char coordinatesLetter = (char) (97 + whitePawnCoordinates[1]);
                    String coordinates = coordinatesLetter + String.valueOf(8 - whitePawnCoordinates[0]);
                    System.out.printf("Game over! White capture on %s.%n", coordinates);
                    capture = true;
                    break;
                } else {
                    board[whitePawnCoordinates[0]][whitePawnCoordinates[1]] = '-';
                    whitePawnCoordinates[0] -= 1;
                    board[whitePawnCoordinates[0]][whitePawnCoordinates[1]] = 'w';
                }
            } else {
                if (whitePawnCoordinates[0] == blackPawnCoordinates[0] + 1 &&
                        (whitePawnCoordinates[1] == blackPawnCoordinates[1] + 1 ||
                                whitePawnCoordinates[1] == blackPawnCoordinates[1] - 1)) {
                    board[blackPawnCoordinates[0]][blackPawnCoordinates[1]] = '-';
                    blackPawnCoordinates[0] = whitePawnCoordinates[0];
                    blackPawnCoordinates[1] = whitePawnCoordinates[1];
                    board[blackPawnCoordinates[0]][blackPawnCoordinates[1]] = 'b';
                    char coordinatesLetter = (char) (97 + blackPawnCoordinates[1]);
                    String coordinates = coordinatesLetter + String.valueOf(8 - blackPawnCoordinates[0]);
                    System.out.printf("Game over! Black capture on %s.%n", coordinates);
                    capture = true;
                    break;
                } else {
                    board[blackPawnCoordinates[0]][blackPawnCoordinates[1]] = '-';
                    blackPawnCoordinates[0] += 1;
                    board[blackPawnCoordinates[0]][blackPawnCoordinates[1]] = 'b';
                }
            }
            turnCounter++;
        }

        if (!capture) {
            if (whitePawnCoordinates[0] == 0) {
                char coordinatesLetter = (char) (97 + whitePawnCoordinates[1]);
                String coordinates = coordinatesLetter + String.valueOf(8 - whitePawnCoordinates[0]);
                System.out.printf("Game over! White pawn is promoted to a queen at %s.%n", coordinates);
            } else if (blackPawnCoordinates[0] == 7) {
                char coordinatesLetter = (char) (97 + blackPawnCoordinates[1]);
                String coordinates = coordinatesLetter + String.valueOf(8 - blackPawnCoordinates[0]);
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n", coordinates);
            }
        }
    }


    private static void initialBoardState(char[][] board, Scanner scanner) {
        for (int i = 0; i < board.length; i++) {
            char[] row = scanner.nextLine().toCharArray();
            board[i] = row;
        }
    }

    private static void findCoordinates(char[][] board, int[] coordinates, char pawn) {
        int figureRow = -1;
        int figureCol = -1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == pawn) {
                    figureRow = i;
                    figureCol = j;
                    break;
                }
            }
        }

        coordinates[0] = figureRow;
        coordinates[1] = figureCol;
    }

}