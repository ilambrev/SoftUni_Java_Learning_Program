package ME07MapsLambdaAndStreamAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ME03MOBAChallenger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> players = new TreeMap<>();

        while (!input.equals("Season end")) {
            if (input.contains(">")) {
                String[] command = input.split(" -> ");
                if (!players.containsKey(command[0])) {
                    players.put(command[0], new TreeMap<>());
                    players.get(command[0]).put(command[1], Integer.parseInt(command[2]));
                } else {
                    if (players.get(command[0]).containsKey(command[1])) {
                        if (players.get(command[0]).get(command[1]) < Integer.parseInt(command[2])) {
                            players.get(command[0]).put(command[1], Integer.parseInt(command[2]));
                        }
                    } else {
                        players.get(command[0]).put(command[1], Integer.parseInt(command[2]));
                    }
                }
            } else {
                String[] command = input.split(" vs ");
                if (players.containsKey(command[0]) && players.containsKey(command[1])) {
                    Map<String, String> demoted = new HashMap<>();
                    for (Map.Entry<String, Integer> entry1 : players.get(command[0]).entrySet()) {
                        for (Map.Entry<String, Integer> entry2 : players.get(command[1]).entrySet()) {
                            if (entry1.getKey().equals(entry2.getKey())) {
                                if (entry1.getValue() > entry2.getValue()) {
                                    demoted.put(entry2.getKey(), command[1]);
                                    break;
                                } else if (entry1.getValue() < entry2.getValue()) {
                                    demoted.put(entry1.getKey(), command[0]);
                                    break;
                                }
                            }
                        }
                    }

                    for (Map.Entry<String, String> entry : demoted.entrySet()) {
                        players.get(entry.getValue()).remove(entry.getKey());
                    }

                    if (players.get(command[0]).isEmpty()) {
                        players.remove(command[0]);
                    }
                    if (players.get(command[1]).isEmpty()) {
                        players.remove(command[1]);
                    }
                }
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> playersTotalScore = new TreeMap<>();

        for (Map.Entry<String, Map<String, Integer>> player : players.entrySet()) {
            for (Map.Entry<String, Integer> entry : player.getValue().entrySet()) {
                if (playersTotalScore.containsKey(player.getKey())) {
                    playersTotalScore.put(player.getKey(), playersTotalScore.get(player.getKey()) + entry.getValue());
                } else {
                    playersTotalScore.put(player.getKey(), entry.getValue());
                }
            }
        }

        playersTotalScore.entrySet().stream().sorted((c1, c2) -> Integer.compare(c2.getValue(), c1.getValue()))
                .forEach(c -> {
                    System.out.printf("%s: %d skill%n", c.getKey(), c.getValue());
                    printPlayers(players.get(c.getKey()));
                });

    }

    private static void printPlayers(Map<String, Integer> playerPositions) {
        playerPositions.entrySet().stream().sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                .forEach(p -> System.out.printf("- %s <::> %d%n", p.getKey(), p.getValue()));
    }

}