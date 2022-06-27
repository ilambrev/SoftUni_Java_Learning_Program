package EX11Exam;

import java.util.Scanner;

public class EX02Snake {
    private static int snakeRow;
    private static int snakeCol;
    private static int foodEaten = 0;
    private static int lairRow;
    private static int lairCol;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int territorySize = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[territorySize][territorySize];

        for (int i = 0; i < territory.length; i++) {
            String rowString = scanner.nextLine();
            for (int j = 0; j < rowString.length(); j++) {
                territory[i][j] = rowString.charAt(j);
                if (territory[i][j] == 'S') {
                    snakeRow = i;
                    snakeCol = j;
                }
            }
        }

        boolean snakeOutOfTerritory = false;

        while (foodEaten < 10) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    snakeOutOfTerritory = snakeMove(territory, -1, 0);
                    break;
                case "down":
                    snakeOutOfTerritory = snakeMove(territory, 1, 0);
                    break;
                case "left":
                    snakeOutOfTerritory = snakeMove(territory, 0, -1);
                    break;
                case "right":
                    snakeOutOfTerritory = snakeMove(territory, 0, 1);
                    break;
            }

            if (foodEaten == 10) {
                System.out.println("You won! You fed the snake.");
                break;
            }

            if (snakeOutOfTerritory) {
                System.out.println("Game over!");
                break;
            }

        }

        System.out.println("Food eaten: " + foodEaten);

        printTerritory(territory);

    }

    private static boolean snakeMove(char[][] territory, int rowModifier, int colModifier) {
        int nextRow = snakeRow + rowModifier;
        int nextCol = snakeCol + colModifier;

        territory[snakeRow][snakeCol] = '.';

        if (nextRow < 0 || nextRow > territory.length - 1 || nextCol < 0 || nextCol > territory.length - 1) {
            return true;
        }

        if (territory[nextRow][nextCol] == '*') {
            foodEaten++;
        } else if (territory[nextRow][nextCol] == 'B') {
            territory[nextRow][nextCol] = '.';
            findLir(territory);
            nextRow = lairRow;
            nextCol = lairCol;
        }

        territory[nextRow][nextCol] = 'S';
        snakeRow = nextRow;
        snakeCol = nextCol;

        return false;
    }

    private static void findLir(char[][] territory) {
        for (int i = 0; i < territory.length; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                if (territory[i][j] == 'B') {
                    lairRow = i;
                    lairCol = j;
                    return;
                }
            }
        }
    }

    private static void printTerritory(char[][] territory) {
        for (int i = 0; i < territory.length; i++) {
            for (int j = 0; j < territory[i].length; j++) {
                System.out.print(territory[i][j]);
            }
            System.out.println();
        }
    }

}