package e01FirstSteps;

import java.util.Scanner;

public class E09FishTank {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percentage = Double.parseDouble(scanner.nextLine());

        double water = (length * width * height) / 1000.0;

        System.out.println(water - percentage * water / 100);
    }
}