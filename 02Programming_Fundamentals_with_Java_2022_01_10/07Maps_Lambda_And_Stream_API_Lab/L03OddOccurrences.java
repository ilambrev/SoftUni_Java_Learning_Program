package L07MapsLambdaAndStreamAPI;

import java.util.*;

public class L03OddOccurrences {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputWords = scanner.nextLine().toLowerCase().split("\\s+");

        Map<String, Integer> words = new LinkedHashMap<>();

        for (String inputWord : inputWords) {
            if (words.containsKey(inputWord)) {
                int currentCount = words.get(inputWord);
                words.put(inputWord, currentCount + 1);
            } else {
                words.put(inputWord, 1);
            }
        }

        List<String> wordsToPrint = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                wordsToPrint.add(entry.getKey());
            }
        }

        if (!wordsToPrint.isEmpty()) {
            for (int i = 0; i < wordsToPrint.size(); i++) {
                System.out.print(wordsToPrint.get(i));
                if (i < wordsToPrint.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

    }
}