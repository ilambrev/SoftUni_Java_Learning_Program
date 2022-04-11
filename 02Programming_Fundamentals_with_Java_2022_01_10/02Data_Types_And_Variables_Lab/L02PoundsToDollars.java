package L02DataTypesAndVariables;

import java.util.Scanner;

public class L02PoundsToDollars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double GBP = Double.parseDouble(scanner.nextLine());

        System.out.printf("%.3f", GBP * 1.36);
    }
}