package EX06Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX02Python {
    private static int pythonRow;
    private static int pythonCol;
    private static int numberOfFood;
    private static int pythonLength;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        pythonLength = 1;

        int screenSize = Integer.parseInt(scanner.nextLine());

        List<String> commands = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        char[][] screen = new char[screenSize][screenSize];

        for (int i = 0; i < screen.length; i++) {
            String[] rowStrings = scanner.nextLine().split("\\s+");
            for (int j = 0; j < rowStrings.length; j++) {
                screen[i][j] = rowStrings[j].charAt(0);
                if (screen[i][j] == 's') {
                    pythonRow = i;
                    pythonCol = j;
                } else if (screen[i][j] == 'f') {
                    numberOfFood++;
                }
            }
        }

        boolean stepOnEnemy = false;

        for (String command : commands) {

            switch (command) {
                case "up":
                    stepOnEnemy = movePython(screen, -1, 0);
                    break;
                case "down":
                    stepOnEnemy = movePython(screen, 1, 0);
                    break;
                case "left":
                    stepOnEnemy = movePython(screen, 0, -1);
                    break;
                case "right":
                    stepOnEnemy = movePython(screen, 0, 1);
                    break;
            }

            if (pythonLength - 1 >= numberOfFood) {
                break;
            }

            if (stepOnEnemy) {
                break;
            }
        }

        if (!stepOnEnemy) {
            if (pythonLength - 1 >= numberOfFood) {
                System.out.println("You win! Final python length is " + pythonLength);
            } else {
                System.out.printf("You lose! There is still %d food to be eaten.%n", numberOfFood - (pythonLength - 1));
            }
        } else {
            System.out.println("You lose! Killed by an enemy!");
        }

    }

    private static boolean movePython(char[][] screen, int rowModifier, int colModifier) {
        int nextRow = pythonRow + rowModifier;
        int nextCol = pythonCol + colModifier;

        screen[pythonRow][pythonCol] = '*';

        if (nextRow < 0) {
            nextRow = screen.length - 1;
        } else if (nextRow > screen.length - 1) {
            nextRow = 0;
        } else if (nextCol < 0) {
            nextCol = screen.length - 1;
        } else if (nextCol > screen.length - 1) {
            nextCol = 0;
        }

        if (screen[nextRow][nextCol] == 'f') {
            pythonLength++;
        } else if (screen[nextRow][nextCol] == 'e') {
            return true;
        }

        screen[nextRow][nextCol] = 's';
        pythonRow = nextRow;
        pythonCol = nextCol;

        return false;
    }

}