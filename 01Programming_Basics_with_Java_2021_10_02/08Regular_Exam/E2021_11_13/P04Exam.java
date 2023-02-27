package E2021_11_13;

import java.util.Scanner;

public class P04Exam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int studentsNumber = Integer.parseInt(scanner.nextLine());

        int poorMarks = 0;
        int averageMarks = 0;
        int goodMarks = 0;
        int excellentMarks = 0;

        double sumOfAllMarks = 0;

        for (int i = 1; i <= studentsNumber; i++) {
            double studentScore = Double.parseDouble(scanner.nextLine());
            if (studentScore < 3.00) {
                poorMarks++;
            } else if (studentScore < 4.00) {
                averageMarks++;
            } else if (studentScore < 5.00) {
                goodMarks++;
            } else {
                excellentMarks++;
            }
            sumOfAllMarks = sumOfAllMarks + studentScore;
        }
        System.out.printf("Top students: %.2f%%%n", excellentMarks * 1.0 / studentsNumber * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", goodMarks * 1.0 / studentsNumber * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", averageMarks * 1.0 / studentsNumber * 100);
        System.out.printf("Fail: %.2f%%%n", poorMarks * 1.0 / studentsNumber * 100);
        System.out.printf("Average: %.2f", sumOfAllMarks / studentsNumber);
    }
}