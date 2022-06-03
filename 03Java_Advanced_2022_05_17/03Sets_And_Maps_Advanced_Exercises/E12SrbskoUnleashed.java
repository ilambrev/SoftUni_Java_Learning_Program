package E03SetsAndMapsAdvanced;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E12SrbskoUnleashed {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("^(?<singer>([A-Za-z]+ ){1,3})@(?<venue>([A-Za-z]+ ){1,3})(?<ticketPrice>\\d+) (?<ticketsCount>\\d+)$");

        String token = scanner.nextLine();

        while (!token.equals("End")) {
            Matcher matcher = pattern.matcher(token);
            while (matcher.find()) {
                String singer = matcher.group("singer").trim();
                String venue = matcher.group("venue").trim();
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));
                Map<String, Integer> singers = new LinkedHashMap<>();
                venues.putIfAbsent(venue, singers);
                venues.get(venue).putIfAbsent(singer, 0);
                int revenue = ticketPrice * ticketsCount + venues.get(venue).get(singer);
                venues.get(venue).put(singer, revenue);
            }

            token = scanner.nextLine();
        }

        for (var venue : venues.entrySet()) {
            System.out.println(venue.getKey());
            venue.getValue().entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(entry -> System.out.println("#  " + entry.getKey() + " -> " + entry.getValue()));
        }

    }
}