package E2021_11_20;

import java.util.Scanner;

public class P01ProgrammingBook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double pagePrice = Double.parseDouble(scanner.nextLine());
        double coverPrice = Double.parseDouble(scanner.nextLine());
        int discountInPercents = Integer.parseInt(scanner.nextLine());
        double designerSalary = Double.parseDouble(scanner.nextLine());
        int percentageFromTeam = Integer.parseInt(scanner.nextLine());

        double price = (pagePrice * 899 + coverPrice * 2)  * (1 - discountInPercents * 1.0 / 100) + designerSalary;

        System.out.printf("Avtonom should pay %.2f BGN.", price - (price * percentageFromTeam / 100));
    }
}