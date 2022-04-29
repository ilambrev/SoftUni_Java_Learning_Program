package ME07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ME02Judge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("no more time")) {
            String[] contest = input.split(" -> ");
            if (!contests.containsKey(contest[1])) {
                contests.put(contest[1], new TreeMap<>());
                contests.get(contest[1]).put(contest[0], Integer.parseInt(contest[2]));
            } else {
                if (contests.get(contest[1]).containsKey(contest[0])) {
                    if (contests.get(contest[1]).get(contest[0]) < Integer.parseInt(contest[2])) {
                        contests.get(contest[1]).put(contest[0], Integer.parseInt(contest[2]));
                    }
                } else {
                    contests.get(contest[1]).put(contest[0], Integer.parseInt(contest[2]));
                }
            }
            input = scanner.nextLine();
        }

        Map<String, Integer> studentsScore = new TreeMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : contests.entrySet()) {
            for (Map.Entry<String, Integer> contest : entry.getValue().entrySet()) {
                if (studentsScore.containsKey(contest.getKey())) {
                    studentsScore.put(contest.getKey(), studentsScore.get(contest.getKey()) + contest.getValue());
                } else {
                    studentsScore.put(contest.getKey(), contest.getValue());
                }
            }
        }

        for (Map.Entry<String, Map<String, Integer>> entry : contests.entrySet()) {
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());
            printContestParticipants(entry.getValue(), "<::>");
        }

        System.out.println("Individual standings:");
        printContestParticipants(studentsScore, "->");

    }

    private static void printContestParticipants(Map<String, Integer> contestParticipants, String separator) {
        int[] i = new int[]{1};
        contestParticipants.entrySet().stream().sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                .forEach(p -> {
                    System.out.printf("%d. %s %s %d%n", i[0], p.getKey(), separator, p.getValue());
                    counter(i);
                });
    }

    private static void counter(int[] i) {
        i[0] += 1;
    }

}