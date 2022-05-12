package EX05MidExam;

import java.util.Scanner;

public class EX01BonusScoringSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int studentsNumber = Integer.parseInt(scanner.nextLine());
        int lecturesNumber = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonusPoints = 0;
        int attendanceWithMaxBonus = 0;


        for (int i = 1; i <= studentsNumber; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = (attendance * 1.0 / lecturesNumber) * (5 + bonus);
            if (totalBonus > maxBonusPoints) {
                maxBonusPoints = totalBonus;
                attendanceWithMaxBonus = attendance;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonusPoints));
        System.out.printf("The student has attended %d lectures.%n", attendanceWithMaxBonus);
    }
}