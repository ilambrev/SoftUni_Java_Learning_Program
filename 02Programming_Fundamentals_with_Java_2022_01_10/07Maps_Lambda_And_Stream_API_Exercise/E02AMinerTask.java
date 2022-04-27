package E07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E02AMinerTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();

        int counter = 0;
        String resource = "";

        while (!input.equals("stop")) {
            counter++;
            if (counter % 2 != 0) {
                resource = input;
                if (!resources.containsKey(input)) {
                    resources.put(input, 0);

                }
            } else {
                int amount = resources.get(resource);
                resources.put(resource, amount + Integer.parseInt(input));
            }

            input = scanner.nextLine();
        }

        printMap(resources);
    }

    private static void printMap(Map<String, Integer> mapArr) {
        for (Map.Entry<String, Integer> entry : mapArr.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

}