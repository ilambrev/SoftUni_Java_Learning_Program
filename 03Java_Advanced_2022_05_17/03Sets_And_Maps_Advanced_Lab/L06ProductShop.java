package L03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class L06ProductShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shops = new TreeMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Revision")) {
            String[] commandParts = command.split(", ");
            String shop = commandParts[0];
            String product = commandParts[1];
            double price = Double.parseDouble(commandParts[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());
            shops.get(shop).put(product, price);

            command = scanner.nextLine();
        }

        for (var shop : shops.entrySet()) {
            System.out.println(shop.getKey() + "->");
            shop.getValue().forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f%n", key, value));
        }

    }
}