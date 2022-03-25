package e01FirstSteps;

import java.util.Scanner;

public class E06Repainting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int thinner = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double sum = (nylon * 1.5 + 2 * 1.5) + (paint * 14.5 * 1.1) + thinner * 5.0 + 0.4;
        double payPerHour = 0.3 * sum;

        System.out.println(sum + hours * payPerHour);
    }
}