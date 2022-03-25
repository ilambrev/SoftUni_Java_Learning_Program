package e01FirstSteps;

import java.util.Scanner;

public class E04VacationBooksList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int bookPages = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int hoursPerDay = (bookPages / days) / pagesPerHour;

        System.out.println(hoursPerDay);

    }
}
