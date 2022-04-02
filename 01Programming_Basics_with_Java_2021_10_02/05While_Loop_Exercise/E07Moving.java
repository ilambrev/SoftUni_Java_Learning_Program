package e05WhileLoop;

import java.util.Scanner;

public class E07Moving {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int volumeWidth = Integer.parseInt(scanner.nextLine());
        int volumeLength = Integer.parseInt(scanner.nextLine());
        int volumeHeight = Integer.parseInt(scanner.nextLine());

        int boxesAmount = volumeWidth * volumeLength * volumeHeight;

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            int boxes = Integer.parseInt(input);
            boxesAmount = boxesAmount - boxes;
            if (boxesAmount <= 0) {
                System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(boxesAmount));
                break;
            }
            input = scanner.nextLine();
        }
        if (input.equals("Done")) {
            System.out.printf("%d Cubic meters left.", boxesAmount);
        }
    }
}