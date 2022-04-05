package E2020_07_18And19;

import java.util.Scanner;

public class P03AluminumJoinery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int joineryNumber = Integer.parseInt(scanner.nextLine());
        String joineryType = scanner.nextLine();
        String deliveryType = scanner.nextLine();

        double orderPrice = 0;

        if (joineryNumber < 10) {
            System.out.println("Invalid order");
        } else {
            switch (joineryType) {
                case "90X130":
                    orderPrice = joineryNumber * 110.0;
                    if (joineryNumber > 30 && joineryNumber <= 60) {
                        orderPrice = orderPrice - orderPrice * 0.05;
                    } else if (joineryNumber > 60) {
                        orderPrice = orderPrice - orderPrice * 0.08;
                    }
                    break;
                case "100X150":
                    orderPrice = joineryNumber * 140.0;
                    if (joineryNumber > 40 && joineryNumber <= 80) {
                        orderPrice = orderPrice - orderPrice * 0.06;
                    } else if (joineryNumber > 80) {
                        orderPrice = orderPrice - orderPrice * 0.10;
                    }
                    break;
                case "130X180":
                    orderPrice = joineryNumber * 190.0;
                    if (joineryNumber > 20 && joineryNumber <= 50) {
                        orderPrice = orderPrice - orderPrice * 0.07;
                    } else if (joineryNumber > 50) {
                        orderPrice = orderPrice - orderPrice * 0.12;
                    }
                    break;
                case "200X300":
                    orderPrice = joineryNumber * 250.0;
                    if (joineryNumber > 25 && joineryNumber <= 50) {
                        orderPrice = orderPrice - orderPrice * 0.09;
                    } else if (joineryNumber > 50) {
                        orderPrice = orderPrice - orderPrice * 0.14;
                    }
                    break;
            }
            if (deliveryType.equals("With delivery")) {
                orderPrice = orderPrice + 60.0;
            }

            if (joineryNumber > 99) {
                orderPrice = orderPrice - orderPrice * 0.04;
            }

            System.out.printf("%.2f BGN", orderPrice);
        }
    }
}