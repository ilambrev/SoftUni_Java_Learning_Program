package E09RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03SoftUniBarIncome {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<customer>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>\\d+)\\|[^|$%.\\d]*(?<price>\\d+|(\\d+\\.\\d{1,2}))\\$$";

        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();

        double totalIncome = 0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                double totalPrice = Double.parseDouble(matcher.group("quantity")) * Double.parseDouble(matcher.group("price"));
                System.out.printf("%s: %s - %.2f%n", matcher.group("customer"), matcher.group("product"), totalPrice);
                totalIncome += totalPrice;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f%n", totalIncome);
    }
}