package EX04Exam;

import java.util.Scanner;

public class EX02MouseAndCheese {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int territorySize = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[territorySize][territorySize];

        fillTerritoryValues(territory, scanner);

        int[] mouseCoordinates = {-1, -1};

        findMouseCoordinates(territory, mouseCoordinates);

        String command = scanner.nextLine();

        int cheeseEaten = 0;

        while (!command.equals("end")) {
            cheeseEaten += mouseMove(territory, command, mouseCoordinates);

            if (mouseCoordinates[0] < 0 || mouseCoordinates[0] > territorySize - 1 || mouseCoordinates[1] < 0 || mouseCoordinates[1] > territorySize - 1) {
                System.out.println("Where is the mouse?");
                break;
            }

            command = scanner.nextLine();
        }

        if (cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }

        printTerritory(territory);

    }

    private static void fillTerritoryValues(char[][] territory, Scanner scanner) {
        for (int i = 0; i < territory.length; i++) {
            char[] row = scanner.nextLine().toCharArray();
            territory[i] = row;
        }
    }

    private static void findMouseCoordinates(char[][] territory, int[] mouseCoordinates) {
        boolean mouseFound = false;
        for (int i = 0; i < territory.length; i++) {
            if (mouseFound) {
                break;
            }
            for (int j = 0; j < territory[i].length; j++) {
                if (territory[i][j] == 'M') {
                    mouseCoordinates[0] = i;
                    mouseCoordinates[1] = j;
                    mouseFound = true;
                    break;
                }
            }
        }
    }

    private static int mouseMove(char[][] territory, String direction, int[] mouseCoordinates) {
        int mouseRow = mouseCoordinates[0];
        int mouseCol = mouseCoordinates[1];
        int cheeseEaten = 0;

        territory[mouseRow][mouseCol] = '-';

        switch (direction) {
            case "up":
                if (mouseRow - 1 >= 0) {
                    if (territory[mouseRow - 1][mouseCol] == 'c') {
                        territory[mouseRow - 1][mouseCol] = 'M';
                        mouseRow -= 1;
                        cheeseEaten++;
                    } else if (territory[mouseRow - 1][mouseCol] == 'B') {
                        territory[mouseRow - 1][mouseCol] = '-';
                        if (mouseRow - 2 >= 0) {
                            if (territory[mouseRow - 1][mouseCol] == 'c') {
                                cheeseEaten++;
                            }
                            territory[mouseRow - 2][mouseCol] = 'M';
                        }
                        mouseRow -= 2;
                    } else {
                        territory[mouseRow - 1][mouseCol] = 'M';
                        mouseRow -= 1;
                    }
                } else {
                    mouseRow -= 1;
                }
                mouseCoordinates[0] = mouseRow;
                break;
            case "down":
                if (mouseRow + 1 < territory.length) {
                    if (territory[mouseRow + 1][mouseCol] == 'c') {
                        territory[mouseRow + 1][mouseCol] = 'M';
                        mouseRow += 1;
                        cheeseEaten++;
                    } else if (territory[mouseRow + 1][mouseCol] == 'B') {
                        territory[mouseRow + 1][mouseCol] = '-';
                        if (mouseRow + 2 < territory.length) {
                            if (territory[mouseRow + 2][mouseCol] == 'c') {
                                cheeseEaten++;
                            }
                            territory[mouseRow + 2][mouseCol] = 'M';
                        }
                        mouseRow += 2;
                    } else {
                        territory[mouseRow + 1][mouseCol] = 'M';
                        mouseRow += 1;
                    }
                } else {
                    mouseRow += 1;
                }
                mouseCoordinates[0] = mouseRow;
                break;
            case "left":
                if (mouseCol - 1 >= 0) {
                    if (territory[mouseRow][mouseCol - 1] == 'c') {
                        territory[mouseRow][mouseCol - 1] = 'M';
                        mouseCol -= 1;
                        cheeseEaten++;
                    } else if (territory[mouseRow][mouseCol - 1] == 'B') {
                        territory[mouseRow][mouseCol - 1] = '-';
                        if (mouseCol - 2 >= 0) {
                            if (territory[mouseRow][mouseCol - 2] == 'c') {
                                cheeseEaten++;
                            }
                            territory[mouseRow][mouseCol - 2] = 'M';
                        }
                        mouseCol -= 2;
                    } else {
                        territory[mouseRow][mouseCol - 1] = 'M';
                        mouseCol -= 1;
                    }
                } else {
                    mouseCol -= 1;
                }
                mouseCoordinates[1] = mouseCol;
                break;
            case "right":
                if (mouseCol + 1 < territory[0].length) {
                    if (territory[mouseRow][mouseCol + 1] == 'c') {
                        territory[mouseRow][mouseCol + 1] = 'M';
                        mouseCol += 1;
                        cheeseEaten++;
                    } else if (territory[mouseRow][mouseCol + 1] == 'B') {
                        territory[mouseRow][mouseCol + 1] = '-';
                        if (mouseCol + 2 < territory[0].length) {
                            if (territory[mouseRow][mouseCol + 2] == 'c') {
                                cheeseEaten++;
                            }
                            territory[mouseRow][mouseCol + 2] = 'M';
                        }
                        mouseCol += 2;
                    } else {
                        territory[mouseRow][mouseCol + 1] = 'M';
                        mouseCol += 1;
                    }
                } else {
                    mouseCol += 1;
                }
                mouseCoordinates[1] = mouseCol;
                break;
        }

        return cheeseEaten;
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