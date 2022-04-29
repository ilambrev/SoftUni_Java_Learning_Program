package ME07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ME05DragonArmy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfDragons = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, Integer[]>> dragons = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfDragons; i++) {
            String[] dragon = scanner.nextLine().split("\\s+");
            int damage = 45;
            int health = 250;
            int armor = 10;
            if (!dragon[2].equals("null")) {
                damage = Integer.parseInt(dragon[2]);
            }
            if (!dragon[3].equals("null")) {
                health = Integer.parseInt(dragon[3]);
            }
            if (!dragon[4].equals("null")) {
                armor = Integer.parseInt(dragon[4]);
            }
            Integer[] dragonStats = new Integer[]{damage, health, armor};
            if (!dragons.containsKey(dragon[0])) {
                dragons.put(dragon[0], new TreeMap<>());
            }
            dragons.get(dragon[0]).put(dragon[1], dragonStats);
        }

        for (Map.Entry<String, Map<String, Integer[]>> entry : dragons.entrySet()) {
            Double[] averageStats = new Double[]{0.0, 0.0, 0.0};
            averageDragonTypeStats(entry.getValue(), averageStats);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), averageStats[0], averageStats[1], averageStats[2]);
            for (Map.Entry<String, Integer[]> dragon : entry.getValue().entrySet()) {
                Integer[] dragonStats = dragon.getValue();
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getKey(), dragonStats[0], dragonStats[1], dragonStats[2]);
            }
        }

    }

    private static void averageDragonTypeStats(Map<String, Integer[]> dragonStats, Double[] averageStats) {
        for (Map.Entry<String, Integer[]> entry : dragonStats.entrySet()) {
            Integer[] currentStats = entry.getValue();
            averageStats[0] += currentStats[0];
            averageStats[1] += currentStats[1];
            averageStats[2] += currentStats[2];
        }
        averageStats[0] /= dragonStats.size();
        averageStats[1] /= dragonStats.size();
        averageStats[2] /= dragonStats.size();
    }

}