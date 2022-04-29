package ME07MapsLambdaAndStreamAPI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ME01Ranking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> contests = new HashMap<>();

        String inputContests = scanner.nextLine();

        while (!inputContests.equals("end of contests")) {
            String[] contest = inputContests.split(":");
            contests.put(contest[0], contest[1]);
            inputContests = scanner.nextLine();
        }

        Map<String, Map<String, Integer>> students = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end of submissions")) {
            String[] contest = input.split("=>");
            if (contests.containsKey(contest[0]) && contests.get(contest[0]).equals(contest[1])) {
                if (students.containsKey(contest[2])) {
                    if (students.get(contest[2]).containsKey(contest[0]) && students.get(contest[2]).get(contest[0]) < Integer.parseInt(contest[3])) {
                        students.get(contest[2]).put(contest[0], Integer.parseInt(contest[3]));
                    } else if (!students.get(contest[2]).containsKey(contest[0])) {
                        students.get(contest[2]).put(contest[0], Integer.parseInt(contest[3]));
                    }
                } else {
                    students.put(contest[2], new HashMap<>());
                    students.get(contest[2]).put(contest[0], Integer.parseInt(contest[3]));
                }
            }
            input = scanner.nextLine();
        }

        studentWithBestResult(students);
        System.out.println("Ranking:");

        for (Map.Entry<String, Map<String, Integer>> entry : students.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream().sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                    .forEach(k -> System.out.printf("#  %s -> %d%n", k.getKey(), k.getValue()));
        }


    }

    private static int countTotalScore(Map<String, Integer> student) {
        int totalScore = 0;
        for (Map.Entry<String, Integer> entry : student.entrySet()) {
            totalScore += entry.getValue();
        }
        return totalScore;
    }

    private static void studentWithBestResult(Map<String, Map<String, Integer>> students) {
        int bestScore = 0;
        String bestStudent = "";
        for (Map.Entry<String, Map<String, Integer>> entry : students.entrySet()) {
            int currentScore = countTotalScore(entry.getValue());
            if (currentScore > bestScore) {
                bestScore = currentScore;
                bestStudent = entry.getKey();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", bestStudent, bestScore);
    }

}