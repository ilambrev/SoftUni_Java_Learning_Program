package e06NestedLoops;

import java.util.Scanner;

public class E04TrainTheTrainers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int juryMembers = Integer.parseInt(scanner.nextLine());
        String presentationName = scanner.nextLine();

        double allPresentationMarksSum = 0;
        int marksCounter = 0;

        while (!presentationName.equals("Finish")) {
            double presentationMarksSum = 0;
            int presentationCounter = 0;
            for (int i = 1; i <= juryMembers; i++) {
                double currentMark = Double.parseDouble(scanner.nextLine());
                presentationMarksSum = presentationMarksSum + currentMark;
                presentationCounter++;
                marksCounter++;
            }
            allPresentationMarksSum = allPresentationMarksSum + presentationMarksSum;
            System.out.printf("%s - %.2f.%n", presentationName, presentationMarksSum / presentationCounter);

            presentationName = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", allPresentationMarksSum / marksCounter);
    }
}