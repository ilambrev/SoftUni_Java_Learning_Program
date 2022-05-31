package E03SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E08UserLogs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> usernames = new TreeMap<>();

        String log = scanner.nextLine();

        while (!log.equals("end")) {
            String[] logFields = log.split("\\s+");
            String ipAddress = logFields[0].substring(3);
            String username = logFields[2].substring(5);
            if (usernames.containsKey(username)) {
                if (usernames.get(username).containsKey(ipAddress)) {
                    int counter = usernames.get(username).get(ipAddress) + 1;
                    usernames.get(username).put(ipAddress, counter);
                } else {
                    usernames.get(username).put(ipAddress, 1);
                }
            } else {
                Map<String, Integer> map = new LinkedHashMap<>();
                map.put(ipAddress, 1);
                usernames.put(username, map);
            }
            log = scanner.nextLine();
        }

        for (String user : usernames.keySet()) {
            System.out.printf("%s:%n", user);
            StringBuilder addresses = new StringBuilder();
            for (String ip : usernames.get(user).keySet()) {
                String address = String.format("%s => %d, ", ip, usernames.get(user).get(ip));
                addresses.append(address);
            }
            addresses.replace(addresses.length() - 2, addresses.length() - 1, ".");
            System.out.println(addresses);
        }

    }
}