package E2021_11_13;

import java.util.Scanner;

public class P01Excursion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int groupMembers = Integer.parseInt(scanner.nextLine());
        int sleepsNumber = Integer.parseInt(scanner.nextLine());
        int transportCards = Integer.parseInt(scanner.nextLine());
        int museumsTickets = Integer.parseInt(scanner.nextLine());

        double totalSum = (groupMembers * (sleepsNumber * 20.0 + transportCards * 1.60 + museumsTickets * 6.0)) * 1.25 ;

        System.out.printf("%.2f", totalSum);
    }
}