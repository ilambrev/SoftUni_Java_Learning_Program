package E2020_03_28And29;

import java.util.Scanner;

public class P01BirthdayParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double hallRent = Double.parseDouble(scanner.nextLine());

        double budget = hallRent + 0.2 * hallRent + (0.2 * hallRent - 0.45 * (0.2 *hallRent)) + hallRent / 3;

        System.out.println(budget);
    }
}