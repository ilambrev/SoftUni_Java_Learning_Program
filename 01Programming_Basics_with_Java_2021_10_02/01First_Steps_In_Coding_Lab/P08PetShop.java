package firstSteps;

import java.util.Scanner;

public class P08PetShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int dogFood = Integer.parseInt(scanner.nextLine());
        int catFood = Integer.parseInt(scanner.nextLine());
        double price = dogFood * 2.50 + catFood * 4;
        //System.out.println(price + " lv.");
        System.out.printf("%.1f lv.", price);
    }
}
