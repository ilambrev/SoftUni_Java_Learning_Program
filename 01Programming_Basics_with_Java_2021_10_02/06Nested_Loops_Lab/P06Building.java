package NestedLoops;

import java.util.Scanner;

public class P06Building {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int floorsNumber = Integer.parseInt(scanner.nextLine());
        int roomsNumber = Integer.parseInt(scanner.nextLine());

        for (int i = floorsNumber; i >= 1; i--) {
            for (int j = 0; j < roomsNumber; j++) {
                if (i == floorsNumber) {
                    System.out.printf("L%d%d ", i, j);
                } else if (i % 2 == 0) {
                    System.out.printf("O%d%d ", i, j);
                } else {
                    System.out.printf("A%d%d ", i, j);
                }
            }
            System.out.println();
        }
    }
}