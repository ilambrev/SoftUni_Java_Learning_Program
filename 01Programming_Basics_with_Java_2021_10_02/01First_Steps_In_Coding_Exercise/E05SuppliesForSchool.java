package e01FirstSteps;

import java.util.Scanner;

public class E05SuppliesForSchool {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int penPacks = Integer.parseInt(scanner.nextLine());
        int markPacks = Integer.parseInt(scanner.nextLine());
        int cleanerLitres = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double sum = (penPacks * 5.8 + markPacks * 7.2 + cleanerLitres * 1.2) * (100 - discount) / 100;

        System.out.println(sum);
    }
}