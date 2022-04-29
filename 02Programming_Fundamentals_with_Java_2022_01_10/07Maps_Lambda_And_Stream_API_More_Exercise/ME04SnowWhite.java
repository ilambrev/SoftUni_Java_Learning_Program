package ME07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ME04SnowWhite {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> dwarfs = new LinkedHashMap<>();

        while (!input.equals("Once upon a time")) {
            String[] dwarf = input.split(" <:> ");
            if (!dwarfs.containsKey(dwarf[1])) {
                dwarfs.put(dwarf[1], new LinkedHashMap<>());
                dwarfs.get(dwarf[1]).put(dwarf[0], Integer.parseInt(dwarf[2]));
            } else {
                if (dwarfs.get(dwarf[1]).containsKey(dwarf[0])) {
                    if (dwarfs.get(dwarf[1]).get(dwarf[0]) < Integer.parseInt(dwarf[2])) {
                        dwarfs.get(dwarf[1]).put(dwarf[0], Integer.parseInt(dwarf[2]));
                    }
                } else {
                    dwarfs.get(dwarf[1]).put(dwarf[0], Integer.parseInt(dwarf[2]));
                }
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> dwarfsByPhysics = new LinkedHashMap<>();

        dwarfs.entrySet().stream().sorted((h1, h2) -> Integer.compare(h2.getValue().size(), h1.getValue().size()))
                .forEach(d -> {
                for (Map.Entry<String, Integer> entry : d.getValue().entrySet()) {
                    dwarfsByPhysics.put("(" + d.getKey() + ") " + entry.getKey(), entry.getValue());
                }
                });

        dwarfsByPhysics.entrySet().stream().sorted((d1, d2) -> Integer.compare(d2.getValue(), d1.getValue()))
                        .forEach(d -> System.out.printf("%s <-> %d%n", d.getKey(), d.getValue()));

    }
}