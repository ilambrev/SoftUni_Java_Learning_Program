package EX13RetakeExam;

import java.util.*;
import java.util.stream.Collectors;

public class EX01SantasPresentFactory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] materialsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] magicLevelsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> materials = new ArrayDeque<>();

        for (Integer material : materialsInput) {
            materials.push(material);
        }

        Deque<Integer> magicLevels = new ArrayDeque<>();

        for (Integer level : magicLevelsInput) {
            magicLevels.offer(level);
        }

        Map<String, Integer> presents = new TreeMap<>();
        presents.put("Doll", 0);
        presents.put("Wooden train", 0);
        presents.put("Teddy bear", 0);
        presents.put("Bicycle", 0);

        while (!materials.isEmpty() && !magicLevels.isEmpty()) {
            int magicLevel = magicLevels.peek();
            int material = materials.peek();
            if (material == 0 || magicLevel == 0) {
                if (material == 0) {
                    materials.pop();
                }
                if (magicLevel == 0) {
                    magicLevels.poll();
                }
                continue;
            }
            magicLevel = magicLevels.poll();
            material = materials.pop();

            int totalMagicLevel = material * magicLevel;

            switch (totalMagicLevel) {
                case 150:
                    int newDollQuantity = presents.get("Doll") + 1;
                    presents.put("Doll", newDollQuantity);
                    break;
                case 250:
                    int newWoodenTrainQuantity = presents.get("Wooden train") + 1;
                    presents.put("Wooden train", newWoodenTrainQuantity);
                    break;
                case 300:
                    int newTeddyBearQuantity = presents.get("Teddy bear") + 1;
                    presents.put("Teddy bear", newTeddyBearQuantity);
                    break;
                case 400:
                    int newBicycleQuantity = presents.get("Bicycle") + 1;
                    presents.put("Bicycle", newBicycleQuantity);
                    break;
                default:
                    if (totalMagicLevel < 0) {
                        int sum = material + magicLevel;
                        materials.push(sum);
                    } else if (totalMagicLevel > 0) {
                        material += 15;
                        materials.push(material);
                    }
                    break;

            }
        }

        if ((presents.get("Doll") > 0 && presents.get("Wooden train") > 0) ||
                (presents.get("Teddy bear") > 0 && presents.get("Bicycle") > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            System.out.println("Materials left: " + materials.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (!magicLevels.isEmpty()) {
            System.out.println("Magic left: " + magicLevels.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.println(presents.entrySet().stream()
                .filter(p -> p.getValue() > 0)
                .map(p -> p.getKey() + ": " + p.getValue()).collect(Collectors.joining(System.lineSeparator())));

    }
}