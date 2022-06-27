package EX10RetakeExam;

import java.util.Scanner;

public class EX02Bee {
    static int beeRow;
    static int beeCol;
    static int pollinatedFlowers;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int territorySize = Integer.parseInt(scanner.nextLine());

        char[][] beeTerritory = new char[territorySize][territorySize];

        for (int i = 0; i < beeTerritory.length; i++) {
            String rowData = scanner.nextLine();
            for (int j = 0; j < rowData.length(); j++) {
                beeTerritory[i][j] = rowData.charAt(j);
                if (beeTerritory[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            boolean beeOutOfTerritory = false;

            switch (command) {
                case "up":
                    beeOutOfTerritory = beeMove(beeTerritory, -1, 0);
                    break;
                case "down":
                    beeOutOfTerritory = beeMove(beeTerritory, 1, 0);
                    break;
                case "left":
                    beeOutOfTerritory = beeMove(beeTerritory, 0, -1);
                    break;
                case "right":
                    beeOutOfTerritory = beeMove(beeTerritory, 0, 1);
                    break;
            }

            if (beeOutOfTerritory) {
                System.out.println("The bee got lost!");
                break;
            }

            command = scanner.nextLine();
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        printBeeTerritory(beeTerritory);

    }

    private static boolean beeMove(char[][] beeTerritory, int rowModifier, int colModifier) {
        int nextRow = beeRow + rowModifier;
        int nextCol = beeCol + colModifier;
        boolean bonusHit = false;

        beeTerritory[beeRow][beeCol] = '.';

        if (nextRow < 0 || nextRow > beeTerritory.length - 1 || nextCol < 0 || nextCol > beeTerritory[nextRow].length - 1) {
            return true;
        }

        if (beeTerritory[nextRow][nextCol] == 'f') {
            pollinatedFlowers++;
        } else if (beeTerritory[nextRow][nextCol] == 'O') {
            bonusHit = true;
        }

        beeTerritory[nextRow][nextCol] = 'B';
        beeRow = nextRow;
        beeCol = nextCol;

        if (bonusHit) {
            beeMove(beeTerritory, rowModifier, colModifier);
        }

        return false;
    }

    private static void printBeeTerritory(char[][] beeTerritory) {
        for (int i = 0; i < beeTerritory.length; i++) {
            for (int j = 0; j < beeTerritory[i].length; j++) {
                System.out.print(beeTerritory[i][j]);
            }
            System.out.println();
        }
    }

}