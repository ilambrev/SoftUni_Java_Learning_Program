package EX20220625Exam;

import java.util.*;
import java.util.stream.Collectors;

public class EX01ItsChocolateTime {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] milkQuantityInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double[] cacaoPowderQuantityInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Deque<Double> milkQuantity = new ArrayDeque<>();

        for (Double milk : milkQuantityInput) {
            milkQuantity.offer(milk);
        }

        Deque<Double> cacaoPowderQuantity = new ArrayDeque<>();

        for (Double cacao : cacaoPowderQuantityInput) {
            cacaoPowderQuantity.push(cacao);
        }

        Map<String, Integer> chocolates = new TreeMap<>();

        while (!milkQuantity.isEmpty() && !cacaoPowderQuantity.isEmpty()) {
            double milk = milkQuantity.poll();
            double cacao = cacaoPowderQuantity.pop();
            double cacaoPercentage = (cacao / (milk + cacao)) * 100;

            if (cacaoPercentage == 30.0) {
                chocolates.putIfAbsent("Milk Chocolate", 0);
                int newMilkChocolateQuantity = chocolates.get("Milk Chocolate") + 1;
                chocolates.put("Milk Chocolate", newMilkChocolateQuantity);
            } else if (cacaoPercentage == 50.0) {
                chocolates.putIfAbsent("Dark Chocolate", 0);
                int newDarkChocolateQuantity = chocolates.get("Dark Chocolate") + 1;
                chocolates.put("Dark Chocolate", newDarkChocolateQuantity);
            } else if (cacaoPercentage == 100.0) {
                chocolates.putIfAbsent("Baking Chocolate", 0);
                int newBakingChocolateQuantity = chocolates.get("Baking Chocolate") + 1;
                chocolates.put("Baking Chocolate", newBakingChocolateQuantity);
            } else {
                milk += 10;
                milkQuantity.offer(milk);
            }
        }

        long numberOfChocolatesOfTypeEqualToThreeOrMore = chocolates.values().stream()
                .filter(c -> c >= 1).count();

        if (numberOfChocolatesOfTypeEqualToThreeOrMore == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        System.out.println(chocolates.entrySet().stream().map(c -> "# " + c.getKey() + " --> " + c.getValue())
                .collect(Collectors.joining(System.lineSeparator())));

    }
}