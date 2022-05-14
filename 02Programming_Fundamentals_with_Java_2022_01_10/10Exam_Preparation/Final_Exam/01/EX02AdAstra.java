package EX01FinalExamRetake;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02AdAstra {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([#|])(?<item>\\b([A-Za-z]*\\s?[A-Za-z]+)+\\b)\\1(?<date>([0-2]\\d|3[0-1])/(0\\d|1[0-2])/\\d{2})\\1(?<calories>\\d|[1-9]\\d{1,3}|10{4})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String[]> items = new ArrayList<>();

        int totalCalories = 0;
        while (matcher.find()) {
            totalCalories += Integer.parseInt(matcher.group("calories"));
            String[] item = new String[]{matcher.group("item"), matcher.group("date"), matcher.group("calories")};
            items.add(item);
        }

        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", days);
        if (!items.isEmpty()) {
            for (String[] item : items) {
                System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", item[0], item[1], item[2]);
            }
        }
    }
}