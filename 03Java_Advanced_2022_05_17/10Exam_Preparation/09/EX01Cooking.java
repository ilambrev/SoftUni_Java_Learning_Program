package EX09RetakeExam;

import java.util.*;
import java.util.stream.Collectors;

public class EX01Cooking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liquids = new ArrayDeque<>();
        Deque<Integer> ingredients = new ArrayDeque<>();
        Map<String, Integer> products = new TreeMap<>();
        products.put("Bread", 0);
        products.put("Cake", 0);
        products.put("Pastry", 0);
        products.put("Fruit Pie", 0);

        String[] inputLiquids = scanner.nextLine().split("\\s+");
        String[] inputIngredients = scanner.nextLine().split("\\s+");

        for (String s : inputLiquids) {
            int liquid = Integer.parseInt(s);
            liquids.offer(liquid);
        }

        for (String s : inputIngredients) {
            int ingredient = Integer.parseInt(s);
            ingredients.push(ingredient);
        }

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int mixture = liquid + ingredient;

            switch (mixture) {
                case 25:
                    int newBreadQuantity = products.get("Bread") + 1;
                    products.put("Bread", newBreadQuantity);
                    break;
                case 50:
                    int newCakeQuantity = products.get("Cake") + 1;
                    products.put("Cake", newCakeQuantity);
                    break;
                case 75:
                    int newPastryQuantity = products.get("Pastry") + 1;
                    products.put("Pastry", newPastryQuantity);
                    break;
                case 100:
                    int newFruitPieQuantity = products.get("Fruit Pie") + 1;
                    products.put("Fruit Pie", newFruitPieQuantity);
                    break;
                default:
                    ingredient += 3;
                    ingredients.push(ingredient);
                    break;

            }
        }

        long productsCreated = products.entrySet().stream().filter(entry -> entry.getValue() > 0).count();

        if (productsCreated == 4) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        for (var entry : products.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}