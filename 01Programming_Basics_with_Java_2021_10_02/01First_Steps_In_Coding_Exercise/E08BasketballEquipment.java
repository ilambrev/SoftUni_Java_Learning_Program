package e01FirstSteps;

import java.util.Scanner;

public class E08BasketballEquipment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int annualFee = Integer.parseInt(scanner.nextLine());

        double sneakers = annualFee - 0.4 * annualFee;
        double equipment = sneakers - 0.2 * sneakers;
        double ball = equipment / 4;
        double accessories = ball / 5;

        System.out.println(annualFee + sneakers + equipment + ball + accessories);
    }
}