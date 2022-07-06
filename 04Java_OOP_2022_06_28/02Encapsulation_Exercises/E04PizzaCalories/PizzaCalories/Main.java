package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            String[] pizzaData = scanner.nextLine().split("\\s+");
            String pizzaName = pizzaData[1];
            int numberOfToppings = Integer.parseInt(pizzaData[2]);

            Pizza pizza = new Pizza(pizzaName, numberOfToppings);

            String[] doughData = scanner.nextLine().split("\\s+");
            String flourType = doughData[1];
            String bakingTechnique = doughData[2];
            double weight = Double.parseDouble(doughData[3]);

            Dough dough = new Dough(flourType, bakingTechnique, weight);

            pizza.setDough(dough);

            String input = scanner.nextLine();

            while (!input.equals("END")) {
                String[] toppingData = input.split("\\s+");
                String toppingName = toppingData[1];
                double toppingWeight = Double.parseDouble(toppingData[2]);

                Topping topping = new Topping(toppingName, toppingWeight);

                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}