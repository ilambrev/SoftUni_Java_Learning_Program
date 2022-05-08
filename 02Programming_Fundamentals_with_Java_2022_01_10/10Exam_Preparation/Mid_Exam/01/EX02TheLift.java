package EX01MidExamRetake;

import java.util.Scanner;

public class EX02TheLift {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int peopleForLift = Integer.parseInt(scanner.nextLine());
        String[] inputArr = scanner.nextLine().split(" ");

        int wagons = inputArr.length;
        int[] wagonsSits = new int[wagons];
        int liftFreeSits = 0;
        int peopleWaiting = peopleForLift;

        for (int i = 0; i < wagons; i++) {
            wagonsSits[i] = Integer.parseInt(inputArr[i]);
            liftFreeSits += 4 - wagonsSits[i];
        }

        for (int i = 0; i < wagons; i++) {
            while (wagonsSits[i] < 4 && peopleWaiting > 0) {
                wagonsSits[i]++;
                peopleWaiting--;
            }
        }
        if (peopleWaiting > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
        } else if (peopleWaiting == 0 && peopleForLift < liftFreeSits) {
            System.out.printf("The lift has empty spots!%n");
        }
        for (int i : wagonsSits) {
            System.out.print(i + " ");
        }
    }
}