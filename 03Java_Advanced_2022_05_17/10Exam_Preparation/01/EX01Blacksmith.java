package EX01RetakeExam;

import java.util.*;
import java.util.stream.Collectors;

public class EX01Blacksmith {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> steel = new ArrayDeque<>();
        Deque<Integer> carbon = new ArrayDeque<>();
        Map<String, Integer> swords = new TreeMap<>();

        int[] steelInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int v : steelInput) {
            steel.offer(v);
        }

        int[] carbonInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int v : carbonInput) {
            carbon.push(v);
        }

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int steelAmount = steel.poll();
            int carbonAmount = carbon.pop();
            int mixture = steelAmount + carbonAmount;
            switch (mixture) {
                case 70:
                    swords.putIfAbsent("Gladius", 0);
                    swords.put("Gladius", swords.get("Gladius") + 1);
                    break;
                case 80:
                    swords.putIfAbsent("Shamshir", 0);
                    swords.put("Shamshir", swords.get("Shamshir") + 1);
                    break;
                case 90:
                    swords.putIfAbsent("Katana", 0);
                    swords.put("Katana", swords.get("Katana") + 1);
                    break;
                case 110:
                    swords.putIfAbsent("Sabre", 0);
                    swords.put("Sabre", swords.get("Sabre") + 1);
                    break;
                default:
                    carbonAmount += 5;
                    carbon.push(carbonAmount);
                    break;
            }

        }


        if (swords.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            int totalNumberOfSwords = swords.values().stream().mapToInt(value -> value).sum();
            System.out.printf("You have forged %d swords.%n", totalNumberOfSwords);
        }

        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            System.out.println(steel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            System.out.println(carbon.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (!swords.isEmpty()) {
            swords.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
        }

    }
}