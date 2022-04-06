package E2020_03_28And29;

import java.util.Scanner;

public class P01ChangeBureau {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int BTC = Integer.parseInt(scanner.nextLine());
        double CNY  = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double EUR = ((BTC * 1168 + (CNY * 0.15) * 1.76) / 1.95) * (1 - commission / 100);

        System.out.printf("%.2f", EUR);
    }
}