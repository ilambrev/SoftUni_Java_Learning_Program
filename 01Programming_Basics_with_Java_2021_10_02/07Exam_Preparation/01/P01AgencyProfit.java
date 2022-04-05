package E2020_07_18And19;

import java.util.Scanner;

public class P01AgencyProfit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String companyName = scanner.nextLine();
        int ticketsForAdults = Integer.parseInt(scanner.nextLine());
        int ticketsForKids = Integer.parseInt(scanner.nextLine());
        double adultTicketPrice = Double.parseDouble(scanner.nextLine());
        double serviceTax = Double.parseDouble(scanner.nextLine());

        double ticketsForAdultsTotal = ((adultTicketPrice + serviceTax) * ticketsForAdults);
        double ticketsForKidsTotal = ((adultTicketPrice * 0.30 + serviceTax) * ticketsForKids);
        double profit = 0.20 * (ticketsForAdultsTotal + ticketsForKidsTotal);

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", companyName, profit);
    }
}