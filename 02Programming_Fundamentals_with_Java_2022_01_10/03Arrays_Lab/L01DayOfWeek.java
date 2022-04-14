package L03Arrays;

import java.util.Scanner;

public class L01DayOfWeek {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dayNumber = Integer.parseInt(scanner.nextLine());

        String[] daysOfWeek = new String[7];

        daysOfWeek[0] = "Monday";
        daysOfWeek[1] = "Tuesday";
        daysOfWeek[2] = "Wednesday";
        daysOfWeek[3] = "Thursday";
        daysOfWeek[4] = "Friday";
        daysOfWeek[5] = "Saturday";
        daysOfWeek[6] = "Sunday";

        if (dayNumber >= 1 && dayNumber <= 7) {
            System.out.println(daysOfWeek[dayNumber-1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}