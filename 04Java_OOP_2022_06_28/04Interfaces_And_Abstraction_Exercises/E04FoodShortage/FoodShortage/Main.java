package FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> foodBuyers = new HashMap<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfPeople; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            if (data.length == 3) {
                Buyer rebel = new Rebel(data[0], Integer.parseInt(data[1]), data[2]);
                foodBuyers.put(data[0], rebel);
            } else if (data.length == 4) {
                Buyer citizen = new Citizen(data[0], Integer.parseInt(data[1]), data[2], data[3]);
                foodBuyers.put(data[0], citizen);
            }
        }

        String name = scanner.nextLine();

        while (!"End".equals(name)) {
            if (foodBuyers.containsKey(name)) {
                foodBuyers.get(name).buyFood();
            }

            name = scanner.nextLine();
        }

        System.out.println(foodBuyers.values().stream()
                .mapToInt(Buyer::getFood)
                .sum());

    }
}