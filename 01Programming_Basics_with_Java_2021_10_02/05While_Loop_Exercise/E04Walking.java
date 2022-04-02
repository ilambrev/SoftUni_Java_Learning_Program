package e05WhileLoop;

import java.util.Scanner;

public class E04Walking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String goal = scanner.nextLine();

        int stepsSum = 0;

        while (!goal.equals("Going home")) {
            int steps = Integer.parseInt(goal);
            stepsSum = stepsSum + steps;
            if (stepsSum >= 10000) {
                System.out.println("Goal reached! Good job!");
                System.out.printf("%d steps over the goal!", stepsSum - 10000);
                break;
            }
            goal = scanner.nextLine();
        }
        if (goal.equals("Going home")) {
            int steps = Integer.parseInt(scanner.nextLine());
            stepsSum = stepsSum + steps;
            if (stepsSum < 10000) {
                System.out.printf("%d more steps to reach goal.", 10000 - stepsSum);
            } else {
                System.out.println("Goal reached! Good job!");
                System.out.printf("%d steps over the goal!", stepsSum - 10000);
            }
        }
    }
}