package e06NestedLoops;

import java.util.Scanner;

public class E06CinemaTickets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String movieTitle = scanner.nextLine();

        int studentTickets = 0;
        int standardTickets = 0;
        int kidTickets = 0;

        while (!movieTitle.equals("Finish")) {
            int freeSits = Integer.parseInt(scanner.nextLine());
            String ticketType = scanner.nextLine();
            int soldTickets = 0;
            while (!ticketType.equals("End")) {
                soldTickets++;
                switch (ticketType) {
                    case "student":
                        studentTickets++;
                        break;
                    case "standard":
                        standardTickets++;
                        break;
                    case "kid":
                        kidTickets++;
                        break;
                }
                if (soldTickets >= freeSits) {
                    break;
                } else {
                    ticketType = scanner.nextLine();
                }
            }
            System.out.printf("%s - %.2f%% full.%n", movieTitle, soldTickets * 1.0 / freeSits * 100);
            movieTitle = scanner.nextLine();
        }
        int ticketsSum = studentTickets + standardTickets + kidTickets;
        System.out.printf("Total tickets: %d%n", ticketsSum);
        System.out.printf("%.2f%% student tickets.%n", studentTickets * 1.0 / ticketsSum * 100);
        System.out.printf("%.2f%% standard tickets.%n", standardTickets * 1.0 / ticketsSum * 100);
        System.out.printf("%.2f%% kids tickets.", kidTickets * 1.0 / ticketsSum * 100);
    }
}