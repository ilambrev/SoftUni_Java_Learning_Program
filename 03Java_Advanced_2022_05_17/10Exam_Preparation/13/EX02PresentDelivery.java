package EX13RetakeExam;

import java.util.Scanner;

public class EX02PresentDelivery {
    private static int santaRow;
    private static int santaCol;
    private static int niceKidsReceivedPresents = 0;
    private static int presentsGiven = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPresents = Integer.parseInt(scanner.nextLine());

        int neighborhoodSize = Integer.parseInt(scanner.nextLine());

        char[][] neighborhood = new char[neighborhoodSize][neighborhoodSize];

        int numberOfNiceKids = 0;

        for (int i = 0; i < neighborhood.length; i++) {
            String[] rowString = scanner.nextLine().split("\\s+");
            for (int j = 0; j < rowString.length; j++) {
                neighborhood[i][j] = rowString[j].charAt(0);
                if (neighborhood[i][j] == 'S') {
                    santaRow = i;
                    santaCol = j;
                } else if (neighborhood[i][j] == 'V') {
                    numberOfNiceKids++;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Christmas morning") && numberOfPresents - presentsGiven > 0) {

            switch (command) {
                case "up":
                    santaMove(neighborhood, -1, 0);
                    break;
                case "down":
                    santaMove(neighborhood, 1, 0);
                    break;
                case "left":
                    santaMove(neighborhood, 0, -1);
                    break;
                case "right":
                    santaMove(neighborhood, 0, 1);
                    break;
            }

            if (numberOfPresents - presentsGiven <= 0) {
                break;
            }

            command = scanner.nextLine();
        }

        if (numberOfPresents - presentsGiven <= 0) {
            System.out.println("Santa ran out of presents!");
        }

        printNeighborhood(neighborhood);

        if (niceKidsReceivedPresents == numberOfNiceKids) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", numberOfNiceKids + presentsGiven - niceKidsReceivedPresents);
        } else {
            System.out.printf("No presents for %d nice kid/s.%n", numberOfNiceKids - niceKidsReceivedPresents);
        }

    }

    private static void santaMove(char[][] neighborhood, int rowModifier, int colModifier) {
        int nextRow = santaRow + rowModifier;
        int nextCol = santaCol + colModifier;

        if (nextRow < 0 || nextRow > neighborhood.length - 1 || nextCol < 0 || nextCol > neighborhood.length - 1) {
            return;
        }

        neighborhood[santaRow][santaCol] = '-';

        if (neighborhood[nextRow][nextCol] == 'V') {
            presentsGiven++;
            niceKidsReceivedPresents++;
        } else if (neighborhood[nextRow][nextCol] == 'C') {

            if (neighborhood[nextRow][nextCol - 1] == 'V' || neighborhood[nextRow][nextCol - 1] == 'X') {
                presentsGiven++;
                if (neighborhood[nextRow][nextCol - 1] == 'V') {
                    niceKidsReceivedPresents++;
                }
                neighborhood[nextRow][nextCol - 1] = '-';
            }

            if (neighborhood[nextRow][nextCol + 1] == 'V' || neighborhood[nextRow][nextCol + 1] == 'X') {
                presentsGiven++;
                if (neighborhood[nextRow][nextCol + 1] == 'V') {
                    niceKidsReceivedPresents++;
                }
                neighborhood[nextRow][nextCol + 1] = '-';
            }

            if (neighborhood[nextRow - 1][nextCol] == 'V' || neighborhood[nextRow - 1][nextCol] == 'X') {
                presentsGiven++;
                if (neighborhood[nextRow - 1][nextCol] == 'V') {
                    niceKidsReceivedPresents++;
                }
                neighborhood[nextRow - 1][nextCol] = '-';
            }

            if (neighborhood[nextRow + 1][nextCol] == 'V' || neighborhood[nextRow + 1][nextCol] == 'X') {
                presentsGiven++;
                if (neighborhood[nextRow + 1][nextCol] == 'V') {
                    niceKidsReceivedPresents++;
                }
                neighborhood[nextRow + 1][nextCol] = '-';
            }

        }

        neighborhood[nextRow][nextCol] = 'S';
        santaRow = nextRow;
        santaCol = nextCol;

    }

    private static void printNeighborhood(char[][] neighborhood) {
        for (int i = 0; i < neighborhood.length; i++) {
            for (int j = 0; j < neighborhood[i].length; j++) {
                System.out.print(neighborhood[i][j] + " ");
            }
            System.out.println();
        }
    }

}