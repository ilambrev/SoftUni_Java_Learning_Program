package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class L04BackIn30Minutes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int timeInMinutes = (hours * 60) + minutes + 30;

        int newHours = timeInMinutes / 60;
        int newMinutes = timeInMinutes % 60;

        if (newHours > 23) {
            newHours -= 24;
        }

        System.out.printf("%d:%02d", newHours, newMinutes);
    }
}