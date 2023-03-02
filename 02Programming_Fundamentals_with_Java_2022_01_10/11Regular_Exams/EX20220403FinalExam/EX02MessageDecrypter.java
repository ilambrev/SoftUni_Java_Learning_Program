package EX20220403FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02MessageDecrypter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        String validateMessage = "^([$%])(?<tag>[A-Z][a-z]{2,})\\1:\\s\\[(?<firstDigit>\\d+)]\\|\\[(?<secondDigit>\\d+)]\\|\\[(?<thirdDigit>\\d+)]\\|$";

        Pattern pattern = Pattern.compile(validateMessage);

        for (int i = 1; i <= numberOfInputs; i++) {
            String message = scanner.nextLine();
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                StringBuilder decodedMessage = new StringBuilder();
                decodedMessage.append((char) Integer.parseInt(matcher.group("firstDigit")));
                decodedMessage.append((char) Integer.parseInt(matcher.group("secondDigit")));
                decodedMessage.append((char) Integer.parseInt(matcher.group("thirdDigit")));
                System.out.println(tag + ": " + decodedMessage);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}