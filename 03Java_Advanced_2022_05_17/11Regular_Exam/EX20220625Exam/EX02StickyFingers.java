package EX20220625Exam;

import java.util.Scanner;

public class EX02StickyFingers {
    private static int dillingerRow;
    private static int dillingerCol;
    private static int totalRobbedSUm = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[fieldSize][fieldSize];

        String[] commands = scanner.nextLine().split(",");

        for (int i = 0; i < field.length; i++) {
            String[] rowString = scanner.nextLine().split("\\s+");
            for (int j = 0; j < rowString.length; j++) {
                field[i][j] = rowString[j].charAt(0);
                if (field[i][j] == 'D') {
                    dillingerRow = i;
                    dillingerCol = j;
                }
            }
        }

        boolean dillingerIsCaught = false;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            switch (command) {
                case "up":
                    dillingerIsCaught = moveDillinger(field, -1, 0);
                    break;
                case "down":
                    dillingerIsCaught = moveDillinger(field, 1, 0);
                    break;
                case "left":
                    dillingerIsCaught = moveDillinger(field, 0, -1);
                    break;
                case "right":
                    dillingerIsCaught = moveDillinger(field, 0, 1);
                    break;
            }

            if (dillingerIsCaught) {
                break;
            }

        }

        if (dillingerIsCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", totalRobbedSUm);
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalRobbedSUm);
        }

        printFiled(field);

    }

    private static boolean moveDillinger(char[][] field, int rowModifier, int colModifier) {
        int nextRow = dillingerRow + rowModifier;
        int nextCol = dillingerCol + colModifier;

        if (nextRow < 0 || nextRow > field.length - 1 || nextCol < 0 || nextCol > field.length - 1) {
            System.out.println("You cannot leave the town, there is police outside!");
            return false;
        }

        field[dillingerRow][dillingerCol] = '+';

        if (field[nextRow][nextCol] == '$') {
            int robbedSum = nextRow * nextCol;
            System.out.printf("You successfully stole %d$.%n", robbedSum);
            totalRobbedSUm += robbedSum;
        } else if (field[nextRow][nextCol] == 'P') {
            field[nextRow][nextCol] = '#';
            return true;
        }

        field[nextRow][nextCol] = 'D';
        dillingerRow = nextRow;
        dillingerCol = nextCol;

        return false;

    }

    private static void printFiled(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
                if (j < field.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}