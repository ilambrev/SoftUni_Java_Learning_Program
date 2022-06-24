package EX05RetakeExam;

import java.util.*;
import java.util.stream.Collectors;

public class EX01PastryShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> foods = new LinkedHashMap<>();
        foods.put("Biscuit", 0);
        foods.put("Cake", 0);
        foods.put("Pie", 0);
        foods.put("Pastry", 0);

        int[] liquidsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> liquids = new ArrayDeque<>();

        Deque<Integer> ingredients = new ArrayDeque<>();

        for (Integer liquid : liquidsInput) {
            liquids.offer(liquid);
        }

        for (Integer ingredient : ingredientsInput) {
            ingredients.push(ingredient);
        }

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int mixture = liquid + ingredient;

            switch (mixture) {
                case 25:
                    int newBiscuitAmount = foods.get("Biscuit") + 1;
                    foods.put("Biscuit", newBiscuitAmount);
                    break;
                case 50:
                    int newCakeAmount = foods.get("Cake") + 1;
                    foods.put("Cake", newCakeAmount);
                    break;
                case 75:
                    int newPastryAmount = foods.get("Pastry") + 1;
                    foods.put("Pastry", newPastryAmount);
                    break;
                case 100:
                    int newPieAmount = foods.get("Pie") + 1;
                    foods.put("Pie", newPieAmount);
                    break;
                default:
                    ingredient += 3;
                    ingredients.push(ingredient);
                    break;
            }
        }

        long numberOfCookedFoodTypes = foods.values().stream().filter(f -> f > 0).count();

        if (numberOfCookedFoodTypes == 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.println(foods.entrySet().stream().map(f -> f.getKey() + ": " + f.getValue()).collect(Collectors.joining(System.lineSeparator())));

    }
}