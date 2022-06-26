package EX08Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX02Bomb {
    private static int sapperRow;
    private static int sapperCol;
    private static int bombsNumber;
    private static int bombsFound;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[fieldSize][fieldSize];

        List<String> directions = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        for (int i = 0; i < field.length; i++) {
            String[] rowString = scanner.nextLine().split("\\s+");
            for (int j = 0; j < rowString.length; j++) {
                field[i][j] = rowString[j].charAt(0);
                if (field[i][j] == 's') {
                    sapperRow = i;
                    sapperCol = j;
                }
            }
        }

        findBombsNumber(field);

        boolean ednReached = false;

        for (String direction : directions) {

            switch (direction) {
                case "up":
                    ednReached = sapperMove(field, -1, 0);
                    break;
                case "down":
                    ednReached = sapperMove(field, 1, 0);
                    break;
                case "left":
                    ednReached = sapperMove(field, 0, -1);
                    break;
                case "right":
                    ednReached = sapperMove(field, 0, 1);
                    break;
            }

            if (bombsFound >= bombsNumber) {
                System.out.println("Congratulations! You found all bombs!");
                break;
            }

            if (ednReached) {
                System.out.printf("END! %d bombs left on the field%n", bombsNumber - bombsFound);
                break;
            }

        }

        if (bombsFound < bombsNumber && !ednReached) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsNumber - bombsFound, sapperRow, sapperCol);
        }

    }

    private static void findBombsNumber(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'B') {
                    bombsNumber++;
                }
            }
        }
    }

    private static boolean sapperMove(char[][] field, int rowModifier, int colModifier) {
        int nextRow = sapperRow + rowModifier;
        int nextCol = sapperCol + colModifier;

        if (nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length) {
            field[sapperRow][sapperCol] = '+';

            if (field[nextRow][nextCol] == 'B') {
                System.out.println("You found a bomb!");
                bombsFound++;
            } else if (field[nextRow][nextCol] == 'e') {
                return true;
            }

            field[nextRow][nextCol] = 's';
            sapperRow = nextRow;
            sapperCol = nextCol;
        }

        return false;
    }

}