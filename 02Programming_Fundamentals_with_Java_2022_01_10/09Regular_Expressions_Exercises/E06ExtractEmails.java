package E09RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E06ExtractEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "\\b(?<email>([A-Za-z0-9]|([A-Za-z0-9]+[._-]*[A-Za-z0-9]+))@[A-Za-z]+([.-][A-Za-z]+)*\\.[A-Za-z]{2,})\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group("email").toLowerCase());
        }
    }
}