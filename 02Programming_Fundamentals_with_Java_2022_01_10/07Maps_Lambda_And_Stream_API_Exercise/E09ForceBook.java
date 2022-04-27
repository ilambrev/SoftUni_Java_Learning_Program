package E07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E09ForceBook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, String>> sides = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String[] command = input.split(" \\| ");
                if (!checkIfUserExists(sides, command[1])) {
                    if (!sides.containsKey(command[0])) {
                        sides.put(command[0], new LinkedHashMap<>());
                        sides.get(command[0]).put(command[1], command[0]);
                    } else {
                        sides.get(command[0]).put(command[1], command[0]);
                    }
                }
            } else {
                String[] command = input.split(" -> ");
                if (checkIfUserExists(sides, command[0])) {
                    if (sides.containsKey(command[1]) && !sides.get(command[1]).containsKey(command[0])) {
                        sides.get(findUserSide(sides, command[0])).remove(command[0]);
                        sides.get(command[1]).put(command[0], command[1]);
                        System.out.printf("%s joins the %s side!%n", command[0], command[1]);
                    } else if (!sides.containsKey(command[1])) {
                        sides.get(findUserSide(sides, command[0])).remove(command[0]);
                        sides.put(command[1], new LinkedHashMap<>());
                        sides.get(command[1]).put(command[0], command[1]);
                        System.out.printf("%s joins the %s side!%n", command[0], command[1]);
                    }
                } else {
                    if (!sides.containsKey(command[1])) {
                        sides.put(command[1], new LinkedHashMap<>());
                        sides.get(command[1]).put(command[0], command[1]);
                    } else {
                        sides.get(command[1]).put(command[0], command[1]);
                    }
                    System.out.printf("%s joins the %s side!%n", command[0], command[1]);
                }

            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, String>> entry : sides.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                for (Map.Entry<String, String> user : entry.getValue().entrySet()) {
                    System.out.printf("! %s%n", user.getKey());
                }
            }
        }

    }

    private static boolean checkIfUserExists(Map<String, Map<String, String>> sides, String user) {
        for (Map.Entry<String, Map<String, String>> entry : sides.entrySet()) {
            if (entry.getValue().containsKey(user)) {
                return true;
            }
        }
        return false;
    }

    private static String findUserSide(Map<String, Map<String, String>> sides, String user) {
        String side = "";
        for (Map.Entry<String, Map<String, String>> entry : sides.entrySet()) {
            if (entry.getValue().containsKey(user)) {
                side = entry.getKey();
            }
        }
        return side;
    }

}