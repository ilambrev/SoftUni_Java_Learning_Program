package EX03RetakeExam;

import java.util.Scanner;

public class EX02ThroneConquering {
    private static int parisRow;
    private static int parisCol;
    private static int parisEnergy;
    private static boolean helenReached;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        parisEnergy = Integer.parseInt(scanner.nextLine());

        int rowsNumber = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[rowsNumber][];

        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'P') {
                    parisRow = i;
                    parisCol = j;
                }
            }
        }

        helenReached = false;
        boolean parisIsDead = false;

        while (parisEnergy > 0) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String direction = commandParts[0];
            int spartanRow = Integer.parseInt(commandParts[1]);
            int spartanCol = Integer.parseInt(commandParts[2]);
            field[spartanRow][spartanCol] = 'S';

            switch (direction) {
                case "up":
                    parisIsDead = parisMove(field, -1, 0);
                    break;
                case "down":
                    parisIsDead = parisMove(field, 1, 0);
                    break;
                case "left":
                    parisIsDead = parisMove(field, 0, -1);
                    break;
                case "right":
                    parisIsDead = parisMove(field, 0, 1);
                    break;
            }

            if (helenReached) {
                break;
            }

            if (parisIsDead) {
                break;
            }

        }

        if (parisIsDead) {
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }

        if (helenReached) {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + parisEnergy);
        }

        printField(field);

    }

    private static boolean parisMove(char[][] field, int rowModifier, int colModifier) {
        int nextRow = parisRow + rowModifier;
        int nextCol = parisCol + colModifier;
        parisEnergy--;

        if (nextRow >= 0 && nextRow < field.length && nextCol >= 0 && nextCol < field[nextRow].length) {
            field[parisRow][parisCol] = '-';

            if (parisEnergy <= 0) {
                field[nextRow][nextCol] = 'X';
                parisRow = nextRow;
                parisCol = nextCol;
                return true;
            }

            if (field[nextRow][nextCol] == 'S') {
                parisEnergy -= 2;
                if (parisEnergy <= 0) {
                    field[nextRow][nextCol] = 'X';
                    parisRow = nextRow;
                    parisCol = nextCol;
                    return true;
                }
            } else if (field[nextRow][nextCol] == 'H') {
                helenReached = true;
                field[nextRow][nextCol] = '-';
                return false;
            }

            field[nextRow][nextCol] = 'P';
            parisRow = nextRow;
            parisCol = nextCol;
        }

        if (parisEnergy <= 0) {
            field[nextRow][nextCol] = 'X';
            parisRow = nextRow;
            parisCol = nextCol;
            return true;
        }

        return false;
    }

    private static void printField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

}