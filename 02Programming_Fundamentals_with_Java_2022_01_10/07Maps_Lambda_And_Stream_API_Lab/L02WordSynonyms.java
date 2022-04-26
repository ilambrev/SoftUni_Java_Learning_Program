package L07MapsLambdaAndStreamAPI;

import java.util.*;

public class L02WordSynonyms {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> wordsWithSynonyms = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfInputs; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            List<String> synonyms;
            if (wordsWithSynonyms.containsKey(word)) {
                synonyms = wordsWithSynonyms.get(word);
            } else {
                synonyms = new ArrayList<>();
            }
            synonyms.add(synonym);
            wordsWithSynonyms.put(word, synonyms);
        }
        for (Map.Entry<String, List<String>> entry : wordsWithSynonyms.entrySet()) {
            System.out.printf("%s - ", entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(entry.getValue().get(i));
                if (i < entry.getValue().size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

//        wordsWithSynonyms.forEach((k, v) -> System.out.printf("%s - %s%n", k, v.toString().replaceAll("[\\[\\]]", "")));
    }
}