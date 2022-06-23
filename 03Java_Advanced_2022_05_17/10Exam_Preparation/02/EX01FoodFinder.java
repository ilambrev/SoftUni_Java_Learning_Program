package EX02Exam;

import java.util.*;

public class EX01FoodFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Character> vowels = new ArrayDeque<>();
        Deque<Character> consonants = new ArrayDeque<>();
        Map<String, List<Character>> words = new LinkedHashMap<>();
        words.put("pear", new ArrayList<>());
        words.put("flour", new ArrayList<>());
        words.put("pork", new ArrayList<>());
        words.put("olive", new ArrayList<>());

        String[] vowelsAsString = scanner.nextLine().split("\\s+");
        String[] consonantsAsString = scanner.nextLine().split("\\s+");

        for (String s : vowelsAsString) {
            vowels.offer(s.charAt(0));
        }

        for (String s : consonantsAsString) {
            consonants.push(s.charAt(0));
        }

        while (!consonants.isEmpty() && !vowels.isEmpty()) {
            char vowel = vowels.poll();
            char consonant = consonants.pop();

            for (var entry : words.entrySet()) {
                if (entry.getValue().size() < entry.getKey().length()) {
                    if (entry.getKey().contains(Character.toString(vowel)) &&
                            !entry.getValue().contains(vowel)) {
                        entry.getValue().add(vowel);
                    }
                }

                if (entry.getValue().size() < entry.getKey().length()) {
                    if (entry.getKey().contains(Character.toString(consonant)) &&
                            !entry.getValue().contains(consonant)) {
                        entry.getValue().add(consonant);
                    }
                }
            }
            vowels.offer(vowel);
        }

        int numberOfFoundWords = 0;
        for (var entry : words.entrySet()) {
            if (entry.getKey().length() == entry.getValue().size()) {
                numberOfFoundWords++;
            }
        }
        System.out.println("Words found: " + numberOfFoundWords);
        for (var entry : words.entrySet()) {
            if (entry.getKey().length() == entry.getValue().size()) {
                System.out.println(entry.getKey());
            }
        }

    }
}