package E09RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02Race {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] participants = scanner.nextLine().split(",\\s");
        Map<String, Integer> results = new LinkedHashMap<>();

        for (String p : participants) {
            results.put(p, 0);
        }

        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            Pattern pattern = Pattern.compile("(?<letter>[A-Za-z])|(?<digit>\\d)");
            Matcher matcher = pattern.matcher(input);
            StringBuilder name = new StringBuilder();
            int distance = 0;
            while (matcher.find()) {
                if (matcher.group("letter") != null) {
                    name.append(matcher.group("letter"));
                }
                if (matcher.group("digit") != null) {
                    distance += Integer.parseInt(matcher.group("digit"));
                }
            }
            if (results.containsKey(String.valueOf(name))) {
                results.put(String.valueOf(name), results.get(String.valueOf(name)) + distance);
            }
            input = scanner.nextLine();
        }

        List<String> bestParticipants = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            boolean isSmallest = true;
            for (int i = 0; i < bestParticipants.size(); i++) {
                if (entry.getValue() > results.get(bestParticipants.get(i))) {
                    bestParticipants.add(i, entry.getKey());
                    isSmallest = false;
                    break;
                }
            }
            if (isSmallest) {
                bestParticipants.add(entry.getKey());
            }
        }

        if (bestParticipants.size() < 3) {
            for (int i = 1; i <= (3 - bestParticipants.size()); i++) {
                bestParticipants.add("");
            }
        }

        System.out.printf("1st place: %s%n", bestParticipants.get(0));
        System.out.printf("2nd place: %s%n", bestParticipants.get(1));
        System.out.printf("3rd place: %s%n", bestParticipants.get(2));
    }
}