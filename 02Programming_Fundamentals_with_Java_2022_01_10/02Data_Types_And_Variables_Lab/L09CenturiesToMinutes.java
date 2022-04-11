package L02DataTypesAndVariables;

import java.util.Scanner;

public class L09CenturiesToMinutes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int centuries = Integer.parseInt(scanner.nextLine());

        int years = centuries * 100;
        long days = Math.round(years * 365.2422);
        long hours = Math.round(years * 365.2422 * 24);
        long minutes = Math.round(years * 365.2422 * 24 * 60);

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centuries, years, days, hours, minutes);
    }
}