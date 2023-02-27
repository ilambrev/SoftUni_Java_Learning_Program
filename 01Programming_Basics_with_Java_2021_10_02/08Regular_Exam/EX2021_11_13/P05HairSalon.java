package E2021_11_13;

import java.util.Scanner;

public class P05HairSalon {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int goalSum = Integer.parseInt(scanner.nextLine());
        String serviceType = scanner.nextLine();

        int dayProfit = 0;
        boolean isValid = false;

        while (!serviceType.equals("closed")) {
            if (serviceType.equals("haircut")) {
                String haircutType = scanner.nextLine();
                switch (haircutType) {
                    case "mens":
                        dayProfit = dayProfit + 15;
                        break;
                    case "ladies":
                        dayProfit = dayProfit + 20;
                        break;
                    case "kids":
                        dayProfit = dayProfit + 10;
                        break;
                }
            } else if (serviceType.equals("color")) {
                String colorType = scanner.nextLine();
                switch (colorType) {
                    case "touch up":
                        dayProfit = dayProfit + 20;
                        break;
                    case "full color":
                        dayProfit = dayProfit + 30;
                        break;
                }
            }
            if (dayProfit >= goalSum) {
                isValid = true;
                break;
            }
            serviceType = scanner.nextLine();
        }
        if (isValid) {
            System.out.println("You have reached your target for the day!");
        } else {
            System.out.printf("Target not reached! You need %dlv. more.%n", goalSum - dayProfit);
        }
        System.out.printf("Earned money: %dlv.", dayProfit);
    }
}