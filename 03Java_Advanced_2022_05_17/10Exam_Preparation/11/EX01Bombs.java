package EX11Exam;

import java.util.*;
import java.util.stream.Collectors;

public class EX01Bombs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] bombEffectsInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] bombCasingsInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> bombEffects = new ArrayDeque<>();

        for (Integer effect : bombEffectsInput) {
            bombEffects.offer(effect);
        }

        Deque<Integer> bombCasings = new ArrayDeque<>();

        for (Integer casing : bombCasingsInput) {
            bombCasings.push(casing);
        }

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        long bombTypesWithQuantityThreeAndMore = 0;

        while (!bombEffects.isEmpty() && !bombCasings.isEmpty()) {
            int effect = bombEffects.peek();
            int casing = bombCasings.peek();
            int mixture = effect + casing;

            switch (mixture) {
                case 40:
                    int newDaturaQuantity = bombs.get("Datura Bombs") + 1;
                    bombs.put("Datura Bombs", newDaturaQuantity);
                    bombEffects.poll();
                    bombCasings.pop();
                    break;
                case 60:
                    int newCherryQuantity = bombs.get("Cherry Bombs") + 1;
                    bombs.put("Cherry Bombs", newCherryQuantity);
                    bombEffects.poll();
                    bombCasings.pop();
                    break;
                case 120:
                    int newSmokeQuantity = bombs.get("Smoke Decoy Bombs") + 1;
                    bombs.put("Smoke Decoy Bombs", newSmokeQuantity);
                    bombEffects.poll();
                    bombCasings.pop();
                    break;
                default:
                    casing = bombCasings.pop();
                    casing -= 5;
                    bombCasings.push(casing);
                    break;

            }

            bombTypesWithQuantityThreeAndMore = bombs.entrySet().stream().filter(b -> b.getValue() >= 3).count();

            if (bombTypesWithQuantityThreeAndMore == 3) {
                break;
            }

        }


        if (bombTypesWithQuantityThreeAndMore == 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println("Bomb Effects: " + bombEffects.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (bombCasings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println("Bomb Casings: " + bombCasings.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.println(bombs.entrySet().stream().map(b -> b.getKey() + ": " + b.getValue()).collect(Collectors.joining(System.lineSeparator())));

    }
}