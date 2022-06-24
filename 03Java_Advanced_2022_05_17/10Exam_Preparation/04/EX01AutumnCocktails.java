package EX04Exam;

import java.util.*;

public class EX01AutumnCocktails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> bucketsOfIngredients = new ArrayDeque<>();
        Deque<Integer> freshnessLevels = new ArrayDeque<>();
        Map<String, Integer> cocktails = new TreeMap<>();

        int[] buckets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] levels = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int b : buckets) {
            bucketsOfIngredients.offer(b);
        }

        for (int l : levels) {
            freshnessLevels.push(l);
        }

        while (!bucketsOfIngredients.isEmpty() && !freshnessLevels.isEmpty()) {
            int bucket = bucketsOfIngredients.poll();
            if (bucket <= 0) {
                continue;
            }
            int level = freshnessLevels.pop();
            int mixture = bucket * level;

            switch (mixture) {
                case 150:
                    cocktails.putIfAbsent("Pear Sour", 0);
                    int newPearSourNumber = cocktails.get("Pear Sour") + 1;
                    cocktails.put("Pear Sour", newPearSourNumber);
                    break;
                case 250:
                    cocktails.putIfAbsent("The Harvest", 0);
                    int newTheHarvestNumber = cocktails.get("The Harvest") + 1;
                    cocktails.put("The Harvest", newTheHarvestNumber);
                    break;
                case 300:
                    cocktails.putIfAbsent("Apple Hinny", 0);
                    int newAppleHinnyNumber = cocktails.get("Apple Hinny") + 1;
                    cocktails.put("Apple Hinny", newAppleHinnyNumber);
                    break;
                case 400:
                    cocktails.putIfAbsent("High Fashion", 0);
                    int newHighFashionNumber = cocktails.get("High Fashion") + 1;
                    cocktails.put("High Fashion", newHighFashionNumber);
                    break;
                default:
                    bucket += 5;
                    bucketsOfIngredients.offer(bucket);
                    break;
            }
        }

        if (cocktails.size() >= 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int sumOfIngredients = 0;
        for (Integer ing : bucketsOfIngredients) {
            sumOfIngredients += ing;
        }

        if (sumOfIngredients > 0) {
            System.out.println("Ingredients left: " + sumOfIngredients);
        }

        for (var entry : cocktails.entrySet()) {
            System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
        }

    }
}