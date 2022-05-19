package EX06FinalExamRetake2019PartII;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX03SantasSecretHelper {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        String inputString = scanner.nextLine();

        String messageValidation = "@(?<name>[A-Za-z]+)[^@!:>-]*!(?<behavior>[GN])!";

        Pattern pattern = Pattern.compile(messageValidation);

        while (!inputString.equals("end")) {
            StringBuilder message = new StringBuilder();
            message.append(inputString);
            for (int i = 0; i < message.length(); i++) {
                char symbol = message.charAt(i);
                symbol -= key;
                String replaceLetter = "" + symbol;
                message.replace(i, i + 1, replaceLetter);
            }
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                if (matcher.group("behavior").equals("G")) {
                    System.out.println(matcher.group("name"));
                }
            }

            inputString = scanner.nextLine();
        }

    }
}