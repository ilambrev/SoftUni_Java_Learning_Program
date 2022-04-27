package E07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05SoftUniParking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        Map<String, String> parkingUsers = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "register":
                    if (parkingUsers.containsKey(command[1])) {
                        System.out.printf("ERROR: already registered with plate number %s%n", parkingUsers.get(command[1]));
                    } else {
                        parkingUsers.put(command[1], command[2]);
                        System.out.printf("%s registered %s successfully%n", command[1], command[2]);
                    }
                    break;
                case "unregister":
                    if (parkingUsers.containsKey(command[1])) {
                        parkingUsers.remove(command[1]);
                        System.out.printf("%s unregistered successfully%n", command[1]);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", command[1]);
                    }
                    break;
            }
        }

        for (Map.Entry<String, String> entry : parkingUsers.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}