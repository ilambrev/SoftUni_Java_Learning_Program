package e02ConditionalStatements;

import java.util.Scanner;

public class E08LunchBreak {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        int episodeDuration = Integer.parseInt(scanner.nextLine());
        int breakDuration = Integer.parseInt(scanner.nextLine());

        double lounchTime = breakDuration / 8.0;
        double restTime = breakDuration / 4.0;
        double movieTime = breakDuration - (lounchTime + restTime);

        if (movieTime >= episodeDuration) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", movieName, Math.ceil(movieTime - episodeDuration));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", movieName, Math.ceil(episodeDuration - movieTime));
        }
    }
}