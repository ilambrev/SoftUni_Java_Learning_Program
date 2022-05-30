package E03SetsAndMapsAdvanced;

import java.util.*;

public class E07HandsOfCards {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cardsValues = new HashMap<>() {{
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
            put("J", 11);
            put("Q", 12);
            put("K", 13);
            put("A", 14);
            put("S", 4);
            put("H", 3);
            put("D", 2);
            put("C", 1);
        }};

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String player = scanner.nextLine();

        while (!player.equals("JOKER")) {
            String[] playerSet = player.split(": ");
            String[] cards = playerSet[1].split(", ");

            String playerName = playerSet[0];
            if (players.containsKey(playerName)) {
                for (String card : cards) {
                    players.get(playerName).add(card);
                }
            } else {
                Set<String> cardsDeck = new HashSet<>(Arrays.asList(cards));
                players.put(playerName, cardsDeck);
            }

            player = scanner.nextLine();
        }

        for (String key : players.keySet()) {
            System.out.println(key + ": " + calculateCardPoints(players, cardsValues, key));
        }

    }

    private static int calculateCardPoints(Map<String, Set<String>> players, Map<String, Integer> cardsValues, String playerName) {
        int cardsPoints = 0;

        for (String card : players.get(playerName)) {
            String cardPower = card.substring(0, card.length() - 1);
            String cardType = card.substring(card.length() - 1);
            cardsPoints += cardsValues.get(cardPower) * cardsValues.get(cardType);
        }

        return cardsPoints;
    }

}