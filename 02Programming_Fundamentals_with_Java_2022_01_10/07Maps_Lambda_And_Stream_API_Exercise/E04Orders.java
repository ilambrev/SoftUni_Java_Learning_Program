package E07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E04Orders {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Double[]> products = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] product = input.split("\\s+");
            Double[] priceAndQuantity;
            if (products.containsKey(product[0])) {
                priceAndQuantity = products.get(product[0]);
                priceAndQuantity[0] = Double.parseDouble(product[1]);
                priceAndQuantity[1] += Double.parseDouble(product[2]);
            } else {
                priceAndQuantity = new Double[]{Double.parseDouble(product[1]), Double.parseDouble(product[2])};
            }
            products.put(product[0], priceAndQuantity);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Double[]> entry : products.entrySet()) {
            Double[] priceAndQuantity = entry.getValue();
            System.out.printf("%s -> %.2f%n", entry.getKey(), priceAndQuantity[0] * priceAndQuantity[1]);
        }
    }
}