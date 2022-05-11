package EX04MidExam;

import java.util.Scanner;

public class EX01GuineaPig {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final double EPS = 0.000001;
        double foodQuantityKG = Double.parseDouble(scanner.nextLine());
        double hayQuantityKG = Double.parseDouble(scanner.nextLine());
        double coverQuantityKG = Double.parseDouble(scanner.nextLine());
        double pigWeightKG = Double.parseDouble(scanner.nextLine());

        int i = 0;

        while (i < 30 && foodQuantityKG > EPS && hayQuantityKG > EPS && coverQuantityKG > EPS) {
            i++;
            foodQuantityKG -= 0.3;
            if (i % 2 == 0) {
                hayQuantityKG -= (0.05 * foodQuantityKG);
            }
            if (i % 3 == 0) {
                coverQuantityKG -= (pigWeightKG * (1.0 / 3));
            }
        }

        if (i == 30 && foodQuantityKG > EPS && hayQuantityKG > EPS && coverQuantityKG > EPS) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n", foodQuantityKG, hayQuantityKG, coverQuantityKG);
        } else {
            System.out.println("Merry must go to the pet store!");
        }

    }
}