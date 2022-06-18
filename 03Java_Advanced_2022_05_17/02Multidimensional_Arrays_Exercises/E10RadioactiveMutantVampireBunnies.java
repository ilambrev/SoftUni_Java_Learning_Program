package E02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E10RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] liarSizeValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = liarSizeValues[0];
        int cols = liarSizeValues[1];

        char[][] liar = new char[rows][cols];

        setInitialLiarState(liar, scanner);

        String commands = scanner.nextLine();

        boolean playerWon = true;
        int[] playerCoordinates = new int[2];

        playerCoordinates(liar, playerCoordinates);

        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            String nextMove = makeTurn(liar, command, playerCoordinates);
            bunniesSpread(liar);
            if (nextMove.equals("player won")) {
                break;
            } else if (nextMove.equals("player is dead")) {
                playerWon = false;
                break;
            } else if (liar[playerCoordinates[0]][playerCoordinates[1]] == 'B') {
                playerWon = false;
                break;
            }
        }

        printLiar(liar);

        if (playerWon) {
            System.out.printf("won: %d %d%n", playerCoordinates[0], playerCoordinates[1]);
        } else {
            System.out.printf("dead: %d %d%n", playerCoordinates[0], playerCoordinates[1]);
        }

    }

    private static void setInitialLiarState(char[][] liar, Scanner scanner) {
        for (int i = 0; i < liar.length; i++) {
            String row = scanner.nextLine();
            char[] rowValues = row.toCharArray();
            liar[i] = rowValues;
        }
    }

    private static void playerCoordinates(char[][] liar, int[] playerCoordinates) {
        boolean playerFound = false;
        for (int i = 0; i < liar.length; i++) {
            for (int j = 0; j < liar[i].length; j++) {
                if (liar[i][j] == 'P') {
                    playerCoordinates[0] = i;
                    playerCoordinates[1] = j;
                    playerFound = true;
                    break;
                }
            }
            if (playerFound) {
                break;
            }
        }
    }

    private static String makeTurn(char[][] liar, char turnDirection, int[] playerCoordinates) {
        String nextMove = "continue";
        int playerRow = playerCoordinates[0];
        int playerCol = playerCoordinates[1];
        switch (turnDirection) {
            case 'R':
                if (playerCol + 1 > liar[playerRow].length - 1) {
                    nextMove = "player won";
                } else {
                    if (liar[playerRow][playerCol + 1] == 'B') {
                        nextMove = "player is dead";
                    } else {
                        liar[playerRow][playerCol + 1] = 'P';
                    }
                    playerCoordinates[1]++;
                }
                break;
            case 'L':
                if (playerCol - 1 < 0) {
                    nextMove = "player won";
                } else {
                    if (liar[playerRow][playerCol - 1] == 'B') {
                        nextMove = "player is dead";
                    } else {
                        liar[playerRow][playerCol - 1] = 'P';
                    }
                    playerCoordinates[1]--;
                }
                break;
            case 'U':
                if (playerRow - 1 < 0) {
                    nextMove = "player won";
                } else {
                    if (liar[playerRow - 1][playerCol] == 'B') {
                        nextMove = "player is dead";
                    } else {
                        liar[playerRow - 1][playerCol] = 'P';
                    }
                    playerCoordinates[0]--;
                }
                break;
            case 'D':
                if (playerRow + 1 > liar.length - 1) {
                    nextMove = "player won";
                } else {
                    if (liar[playerRow + 1][playerCol] == 'B') {
                        nextMove = "player is dead";
                    } else {
                        liar[playerRow + 1][playerCol] = 'P';
                    }
                    playerCoordinates[0]++;
                }
                break;
        }
        liar[playerRow][playerCol] = '.';

        return nextMove;
    }

    private static void bunniesSpread(char[][] liar) {
        for (int i = 0; i < liar.length; i++) {
            for (int j = 0; j < liar[i].length; j++) {
                if (liar[i][j] == 'B') {
                    if (i - 1 >= 0) {
                        if (liar[i - 1][j] == '.' || liar[i - 1][j] == 'P') {
                            liar[i - 1][j] = 'N';
                        }
                    }
                    if (i + 1 < liar.length) {
                        if (liar[i + 1][j] == '.' || liar[i + 1][j] == 'P') {
                            liar[i + 1][j] = 'N';
                        }
                    }
                    if (j - 1 >= 0) {
                        if (liar[i][j - 1] == '.' || liar[i][j - 1] == 'P') {
                            liar[i][j - 1] = 'N';
                        }
                    }
                    if (j + 1 < liar[i].length) {
                        if (liar[i][j + 1] == '.' || liar[i][j + 1] == 'P') {
                            liar[i][j + 1] = 'N';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < liar.length; i++) {
            for (int j = 0; j < liar[i].length; j++) {
                if (liar[i][j] == 'N') {
                    liar[i][j] = 'B';
                }
            }
        }

    }

    private static void printLiar(char[][] liar) {
        for (int i = 0; i < liar.length; i++) {
            for (int j = 0; j < liar[i].length; j++) {
                System.out.print(liar[i][j]);
            }
            System.out.println();
        }
    }

}