package ME09RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME04SantasSecretHelper {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());

        String inputMessage = scanner.nextLine();

        String nameAndBehavior = "@(?<name>[A-Za-z]+)[^@!:>-]*!(?<behavior>[GN])!";
        Pattern pattern = Pattern.compile(nameAndBehavior);

        while (!inputMessage.equals("end")) {
            StringBuilder decodedMessage = new StringBuilder();
            for (int i = 0; i < inputMessage.length(); i++) {
                int symbolCode = inputMessage.charAt(i);
                symbolCode -= key;
                char newSymbol = (char) symbolCode;
                decodedMessage.append(newSymbol);
            }
            Matcher matcher = pattern.matcher(decodedMessage);
            if (matcher.find() && matcher.group("behavior").equals("G")) {
                System.out.println(matcher.group("name"));
            }

            inputMessage = scanner.nextLine();
        }
    }
}