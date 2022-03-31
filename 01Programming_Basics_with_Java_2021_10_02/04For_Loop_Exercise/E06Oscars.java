package e04ForLoop;

import java.util.Scanner;

public class E06Oscars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String actorName = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int juryMembersNumber = Integer.parseInt(scanner.nextLine());

        double totalPoints = academyPoints;

        for (int i = 1; i <= juryMembersNumber; i++) {
            String memberName = scanner.nextLine();
            double memberPoints = Double.parseDouble(scanner.nextLine());
            int  length  = memberName.length();
            totalPoints = totalPoints + length * memberPoints / 2;
            if (totalPoints >= 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actorName, totalPoints);
                break;
            }
        }
        if (totalPoints < 1250.5) {
            System.out.printf("Sorry, %s you need %.1f more!", actorName, 1250.5 - totalPoints);
        }
    }
}