package e05WhileLoop;

import java.util.Scanner;

public class E02ExamPreparation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int badMarks = Integer.parseInt(scanner.nextLine());
        String problemName = scanner.nextLine();
        int badMarksCounter = 0;
        double marksSum = 0;
        int problemsCounter = 0;
        String lastProblem = "";

        while (!problemName.equals("Enough")) {
            int mark = Integer.parseInt(scanner.nextLine());
            if (mark <= 4) {
               badMarksCounter ++;
            }
            if (badMarksCounter >= badMarks) {
                break;
            }
            marksSum = marksSum + mark;
            lastProblem = problemName;
            problemsCounter ++;
            problemName = scanner.nextLine();
        }
        if (badMarksCounter >= badMarks) {
            System.out.printf("You need a break, %d poor grades.", badMarksCounter);
        } else {
            System.out.printf("Average score: %.2f%n", marksSum / problemsCounter);
            System.out.printf("Number of problems: %d%n", problemsCounter);
            System.out.printf("Last problem: %s", lastProblem);
        }
    }
}