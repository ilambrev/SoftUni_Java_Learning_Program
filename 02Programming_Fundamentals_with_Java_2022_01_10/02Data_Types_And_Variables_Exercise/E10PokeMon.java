package E02DataTypesAndVariables;

import java.util.Scanner;

public class E10PokeMon {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int initialPower = power;

        int targets = 0;

        while (power >= distance) {
            targets++;
            power -= distance;
            if (power == 0.5 * initialPower && exhaustionFactor > 0) {
                power /= exhaustionFactor;
            }
        }
        System.out.println(power);
        System.out.println(targets);
    }
}