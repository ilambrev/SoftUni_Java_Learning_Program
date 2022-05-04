package E09RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E05NetherRealms {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[,]|[, ]+");

        String namesValidation = "^[^, ]+$";
        String healthSymbols = "[^0-9.+*/-]";
        String damageNumbers = "(?<decimal>([+-]?[1-9][0-9]+\\.[0-9]*[1-9])|([+-]?[0-9]\\.[0-9]*[1-9]))|(?<integer>[+-]?[1-9][0-9]+|[+-]?[0-9])";
        String additionalOperation = "[*/]";

        for (String demon : input) {
            Pattern pattern = Pattern.compile(namesValidation);
            Matcher matcher = pattern.matcher(demon);
            while (matcher.find()) {
                int health = calculateHealth(matcher.group(), healthSymbols);
                double damage = calculateInitialDamage(matcher.group(), damageNumbers);
                Pattern pattern1 = Pattern.compile(additionalOperation);
                Matcher matcher1 = pattern1.matcher(matcher.group());
                while (matcher1.find()) {
                    if (matcher1.group().equals("*")) {
                        damage *= 2;
                    } else {
                        damage /= 2;
                    }
                }
                System.out.printf("%s - %d health, %.2f damage%n", matcher.group(), health, damage);
            }
        }
    }

    private static int calculateHealth(String demon, String regex) {
        int health = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(demon);
        while (matcher.find()) {
            health += matcher.group().charAt(0);
        }
        return health;
    }

    private static double calculateInitialDamage(String demon, String regex) {
        double damage = 0.0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(demon);
        while (matcher.find()) {
            if (matcher.group("decimal") != null) {
                damage += Double.parseDouble(matcher.group("decimal"));
            }
            if (matcher.group("integer") != null) {
                damage += Integer.parseInt(matcher.group("integer"));
            }
        }
        return damage;
    }

}