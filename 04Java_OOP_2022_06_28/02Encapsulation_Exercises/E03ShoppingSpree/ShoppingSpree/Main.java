package ShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Person> persons = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        String[] personsData = scanner.nextLine().split(";");
        String[] productsData = scanner.nextLine().split(";");

        for (String data : personsData) {
            String[] personData = data.split("=");
            String personName = personData[0];
            double money = Double.parseDouble(personData[1]);

            try {
                Person person = new Person(personName, money);
                persons.put(personName, person);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        for (String data : productsData) {
            String[] productData = data.split("=");
            String productName = productData[0];
            double cost = Double.parseDouble(productData[1]);

            try {
                Product product = new Product(productName, cost);
                products.put(productName, product);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] data = input.split("\\s+");

            String personName = data[0];
            String productName = data[1];

            Person person = persons.get(personName);
            Product product = products.get(productName);

            try {
                person.buyProduct(product);

                System.out.printf("%s bought %s%n", personName, productName);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }

        for (var entry : persons.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}