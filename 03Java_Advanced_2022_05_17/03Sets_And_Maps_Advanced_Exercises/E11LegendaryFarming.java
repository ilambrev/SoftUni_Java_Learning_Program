package E03SetsAndMapsAdvanced;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E11LegendaryFarming {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();

        boolean legendaryItemObtained = false;

        while (!legendaryItemObtained) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();
                switch (material) {
                    case "shards":
                        materials.put(material, materials.get(material) + quantity);
                        if (materials.get("shards") >= 250) {
                            materials.put("shards", materials.get("shards") - 250);
                            legendaryItemObtained = true;
                            System.out.println("Shadowmourne obtained!");
                        }
                        break;
                    case "fragments":
                        materials.put(material, materials.get(material) + quantity);
                        if (materials.get("fragments") >= 250) {
                            materials.put("fragments", materials.get("fragments") - 250);
                            legendaryItemObtained = true;
                            System.out.println("Valanyr obtained!");
                        }
                        break;
                    case "motes":
                        materials.put(material, materials.get(material) + quantity);
                        if (materials.get("motes") >= 250) {
                            materials.put("motes", materials.get("motes") - 250);
                            legendaryItemObtained = true;
                            System.out.println("Dragonwrath obtained!");
                        }
                        break;
                    default:
                        junkMaterials.putIfAbsent(material, 0);
                        junkMaterials.put(material, junkMaterials.get(material) + quantity);
                        break;
                }
                if (legendaryItemObtained) {
                    break;
                }
            }

        }

        materials.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        for (var junk : junkMaterials.entrySet()) {
            System.out.println(junk.getKey() + ": " + junk.getValue());
        }

    }
}