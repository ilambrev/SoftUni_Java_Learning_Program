package E03SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E10LogsAggregator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLogs = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        for (int i = 1; i <= numberOfLogs; i++) {
            String[] log = scanner.nextLine().split("\\s+");
            String ipAddress = log[0];
            String username = log[1];
            int sessionDuration = Integer.parseInt(log[2]);

            users.putIfAbsent(username, new TreeMap<>());
            users.get(username).putIfAbsent(ipAddress, 0);
            sessionDuration += users.get(username).get(ipAddress);
            users.get(username).put(ipAddress, sessionDuration);
        }

        users.forEach((key, value) -> {
            int duration = value.values().stream().mapToInt(v -> v).sum();
            System.out.printf("%s: %d ", key, duration);
            System.out.print(String.join(", ", new ArrayList<>(value.keySet()).toString()));
            System.out.println();
        });

    }
}