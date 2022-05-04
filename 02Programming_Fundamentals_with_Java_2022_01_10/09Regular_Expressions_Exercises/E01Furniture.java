package E09RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E01Furniture {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "^>>(?<article>\\w+)<<(?<price>\\d+(\\.\\d+)?)!(?<quantity>\\d+)";

        double totalPrice = 0;

        List<String> articles = new ArrayList<>();

        while (!input.equals("Purchase")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find() && Double.parseDouble(matcher.group("price")) > 0 && Integer.parseInt(matcher.group("quantity")) > 0) {
                double articleTotalPrice = Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
                totalPrice += articleTotalPrice;
                articles.add(matcher.group("article"));
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String a : articles) {
            System.out.println(a);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}