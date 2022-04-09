package E01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class E10PadawanEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int studentsNumber = Integer.parseInt(scanner.nextLine());
        double saberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double totalSum = 0;

        double saberTotalPrice = (studentsNumber + Math.ceil(studentsNumber * 0.10)) * saberPrice;
        double robeTotalPrice = studentsNumber * robePrice;
        double beltTotalPrice = (studentsNumber - Math.floor(studentsNumber / 6.0)) * beltPrice;
        totalSum = saberTotalPrice + robeTotalPrice + beltTotalPrice;

        if (totalSum <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSum);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalSum - budget);
        }
    }
}