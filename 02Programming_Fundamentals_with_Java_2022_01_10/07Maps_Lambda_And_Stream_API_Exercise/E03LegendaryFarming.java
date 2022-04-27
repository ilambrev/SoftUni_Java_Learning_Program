package E07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E03LegendaryFarming {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new LinkedHashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        boolean materialQuantityReached = false;
        String legendaryItem = null;

        while (!materialQuantityReached) {
            String[] input = scanner.nextLine().toLowerCase().split("\\s+");
            for (int i = 1; i < input.length; i += 2) {
                if (!materials.containsKey(input[i])) {
                    materials.put(input[i], Integer.parseInt(input[i - 1]));
                } else {
                    int quantity = materials.get(input[i]);
                    materials.put(input[i], quantity + Integer.parseInt(input[i - 1]));
                }
                if (input[i].equals("shards") || input[i].equals("fragments") || input[i].equals("motes")) {
                    legendaryItem = legendaryItemWin(materials);
                    if (legendaryItem != null) {
                        String[] materialForLegendaryItem = legendaryItem.split(" ");
                        System.out.println(materialForLegendaryItem[0] + " obtained!");
                        int quantity = materials.get(materialForLegendaryItem[1]);
                        materials.put(materialForLegendaryItem[1], quantity - 250);
                        materialQuantityReached = true;
                        break;
                    }
                }
            }

        }

        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            if (entry.getKey().equals("shards") || entry.getKey().equals("fragments") || entry.getKey().equals("motes")) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            if (!entry.getKey().equals("shards") && !entry.getKey().equals("fragments") && !entry.getKey().equals("motes")) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

    }

    private static String legendaryItemWin(Map<String, Integer> materials) {
        String legendaryItem = null;
        String[] legendaryItemsMaterials = new String[]{"shards", "fragments", "motes"};
        if (materials.containsKey(legendaryItemsMaterials[0]) && materials.get(legendaryItemsMaterials[0]) >= 250) {
            legendaryItem = "Shadowmourne" + " " + legendaryItemsMaterials[0];
        } else if (materials.containsKey(legendaryItemsMaterials[1]) && materials.get(legendaryItemsMaterials[1]) >= 250) {
            legendaryItem = "Valanyr" + " " + legendaryItemsMaterials[1];
        } else if (materials.containsKey(legendaryItemsMaterials[2]) && materials.get(legendaryItemsMaterials[2]) >= 250) {
            legendaryItem = "Dragonwrath" + " " + legendaryItemsMaterials[2];
        }
        return legendaryItem;
    }

}
