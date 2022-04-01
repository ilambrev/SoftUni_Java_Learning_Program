package whileLoop;

import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int classGrade = 1;
        int badResult = 0;

        double grade = 0.0;

        while (classGrade <= 12) {
            if (badResult > 1) {
                break;
            }
            double currentMark = Double.parseDouble(scanner.nextLine());
            if (currentMark < 4) {
                badResult ++;
                continue;
            }
            grade = grade + currentMark;
            classGrade ++;
        }
        if (badResult >= 1) {
            System.out.printf("%s has been excluded at %d grade", name, classGrade);
        } else {
            System.out.printf("%s graduated. Average grade: %.2f", name, grade / 12);
        }
    }
}