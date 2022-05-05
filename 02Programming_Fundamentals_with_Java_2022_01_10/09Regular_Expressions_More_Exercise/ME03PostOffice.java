package ME09RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME03PostOffice {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\|");

        Map<Integer, Character> letters = new LinkedHashMap<>();
        Map<String, Integer> wordsLengths = new LinkedHashMap<>();
        List<String> words = new ArrayList<>();

        findCapitalLetters(letters, strings[0]);
        findWordLength(wordsLengths, letters, strings[1]);
        findWord(letters, wordsLengths, words, strings[2]);

        for (String word : words) {
            System.out.println(word);
        }

    }

    private static void findCapitalLetters(Map<Integer, Character> letters, String firstPart) {
        Pattern pattern = Pattern.compile("([*#$%&])(?<letters>[A-Z]+)\\1");
        Matcher matcher = pattern.matcher(firstPart);
        while (matcher.find()) {
            String capitalLetters = matcher.group("letters");
            for (int i = 0; i < capitalLetters.length(); i++) {
                int letterCode = capitalLetters.charAt(i);
                letters.put(letterCode, capitalLetters.charAt(i));
            }
        }
    }

    private static void findWordLength(Map<String, Integer> wordsLengths, Map<Integer, Character> letters, String secondPart) {
        String findWordLength = "(?<firstLetter>[0-9]{2}):(?<wordLength>(0[1-9])|(1[0-9])|20)";
        Pattern pattern = Pattern.compile(findWordLength);
        Matcher matcher = pattern.matcher(secondPart);
        while (matcher.find()) {
            int letterCode = Integer.parseInt(matcher.group("firstLetter"));
            if (letters.containsKey(letterCode)) {
                wordsLengths.put(matcher.group(), letterCode);
            }

        }
    }

    private static void findWord(Map<Integer, Character> letters, Map<String, Integer> wordsLengths, List<String> words, String thirdPart) {
        String findWord = "\\b(?<word>[A-Z][^\\s]+)\\b";
        Pattern pattern = Pattern.compile(findWord);
        for (Map.Entry<Integer, Character> entry : letters.entrySet()) {
            for (Map.Entry<String, Integer> entry1 : wordsLengths.entrySet()) {
                if (entry1.getValue() == entry.getKey().intValue()) {
                    char firstLetter = entry.getValue();
                    int wordLength = Integer.parseInt(entry1.getKey().substring(3)) + 1;
                    Matcher matcher = pattern.matcher(thirdPart);
                    while (matcher.find()) {
                        String word = matcher.group("word");
                        if (word.charAt(0) == firstLetter && word.length() == wordLength) {
                            words.add(word);
                        }
                    }
                }
            }
        }
    }

}