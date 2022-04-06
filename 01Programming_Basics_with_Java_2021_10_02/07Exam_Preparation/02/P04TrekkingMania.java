package E2020_03_28And29;

import java.util.Scanner;

public class P04TrekkingMania {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int groupsNumber = Integer.parseInt(scanner.nextLine());

        int counterMusala = 0;
        int counterMontBlanc = 0;
        int counterKilimanjaro = 0;
        int counterK2 = 0;
        int counterEverest = 0;

        for (int i = 1; i <= groupsNumber; i++) {
            int groupMembers = Integer.parseInt(scanner.nextLine());
            if (groupMembers <= 5) {
                counterMusala = counterMusala + groupMembers;
            } else if (groupMembers <= 12) {
                counterMontBlanc = counterMontBlanc + groupMembers;
            } else if (groupMembers <= 25) {
                counterKilimanjaro = counterKilimanjaro + groupMembers;
            } else if (groupMembers <= 40) {
                counterK2 = counterK2 + groupMembers;
            } else {
                counterEverest = counterEverest + groupMembers;
            }
        }
        int allClimbers = counterMusala + counterMontBlanc + counterKilimanjaro + counterK2 + counterEverest;
        System.out.printf("%.2f%%%n", counterMusala * 1.0 / allClimbers * 100);
        System.out.printf("%.2f%%%n", counterMontBlanc * 1.0 / allClimbers * 100);
        System.out.printf("%.2f%%%n", counterKilimanjaro * 1.0 / allClimbers * 100);
        System.out.printf("%.2f%%%n", counterK2 * 1.0 / allClimbers * 100);
        System.out.printf("%.2f%%", counterEverest * 1.0 / allClimbers * 100);
    }
}