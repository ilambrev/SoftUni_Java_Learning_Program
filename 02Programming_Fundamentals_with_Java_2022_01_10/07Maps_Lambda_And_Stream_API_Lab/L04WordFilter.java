package L07MapsLambdaAndStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class L04WordFilter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        List<String> filteredWords = Arrays.stream(words)
                .toList().stream()
                .filter(s -> s.length() % 2 == 0).toList();

        for(String s : filteredWords) {
            System.out.println(s);
        }
    }
}