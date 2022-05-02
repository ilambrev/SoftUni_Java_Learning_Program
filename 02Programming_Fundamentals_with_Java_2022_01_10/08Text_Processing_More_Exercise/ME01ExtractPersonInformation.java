package ME08TextProcessing;

import java.util.Scanner;

public class ME01ExtractPersonInformation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfLines; i++) {
            String inputLine = scanner.nextLine();
            String name = inputLine.substring(inputLine.indexOf('@') + 1, inputLine.indexOf('|'));
            String age = inputLine.substring(inputLine.indexOf('#') + 1, inputLine.indexOf('*'));
            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}