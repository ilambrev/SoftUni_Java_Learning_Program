package e04ForLoop;

import java.util.Scanner;

public class E07TrekkingMania {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int groupsNum = Integer.parseInt(scanner.nextLine());

        int toMusala = 0;
        int toMontBlanc = 0;
        int toKilimanjaro = 0;
        int toK2 = 0;
        int toEverest = 0;

        double totalNumber = 0;

        for (int i = 1; i <= groupsNum; i++) {
            int groupMembers = Integer.parseInt(scanner.nextLine());
            if (groupMembers <= 5) {
                toMusala = toMusala + groupMembers;
            } else if (groupMembers <= 12) {
                toMontBlanc = toMontBlanc + groupMembers;
            } else if (groupMembers <= 25) {
                toKilimanjaro = toKilimanjaro + groupMembers;
            } else if (groupMembers <= 40) {
                toK2 = toK2 + groupMembers;
            } else {
                toEverest = toEverest + groupMembers;
            }
            totalNumber = totalNumber + groupMembers;
        }
        System.out.printf("%.2f%%%n", toMusala / totalNumber * 100);
        System.out.printf("%.2f%%%n", toMontBlanc / totalNumber * 100);
        System.out.printf("%.2f%%%n", toKilimanjaro / totalNumber * 100);
        System.out.printf("%.2f%%%n", toK2 / totalNumber * 100);
        System.out.printf("%.2f%%%n", toEverest / totalNumber * 100);
    }
}