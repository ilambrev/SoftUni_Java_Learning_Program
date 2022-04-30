package L08TextProcessing;

import java.util.Scanner;

public class L03Substring {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String textToRemove = scanner.nextLine();

        String text = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        result.append(text);

        int index = result.indexOf(textToRemove);

        while (index != -1) {
            result.replace(index, (index + textToRemove.length()), "");
            index = result.indexOf(textToRemove);
        }

        System.out.println(result);
    }
}