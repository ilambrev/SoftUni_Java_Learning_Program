package e03ConditionalStatementsAdvanced;

import java.util.Scanner;

public class E08OnTimeForTheExam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        int examTimeInMinutes = examHour * 60 + examMinutes;
        int arrivalTimeInMinutes = arrivalHour * 60 + arrivalMinutes;
        int minutesDifference = Math.abs(arrivalTimeInMinutes - examTimeInMinutes);
        int differenceInHours = minutesDifference / 60;
        int differenceInMinutes = minutesDifference % 60;

        if (arrivalTimeInMinutes > examTimeInMinutes && differenceInHours == 0) {
            System.out.printf("Late%n%d minutes after the start", minutesDifference);
        } else if (arrivalTimeInMinutes > examTimeInMinutes && differenceInHours > 0) {
            System.out.printf("Late%n%d:%02d hours after the start", differenceInHours, differenceInMinutes);
        } else if (arrivalTimeInMinutes == examTimeInMinutes) {
            System.out.print("On time");
        } else if (arrivalTimeInMinutes < examTimeInMinutes && differenceInHours == 0 && differenceInMinutes <= 30) {
            System.out.printf("On time%n%d minutes before the start", differenceInMinutes);
        } else if (arrivalTimeInMinutes < examTimeInMinutes && differenceInHours == 0) {
            System.out.printf("Early%n%d minutes before the start", differenceInMinutes);
        } else if (arrivalTimeInMinutes < examTimeInMinutes && differenceInHours > 0) {
            System.out.printf("Early%n%d:%02d hours before the start", differenceInHours, differenceInMinutes);
        }
    }
}