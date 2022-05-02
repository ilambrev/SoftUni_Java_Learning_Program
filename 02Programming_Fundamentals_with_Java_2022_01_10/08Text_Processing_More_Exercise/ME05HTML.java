package ME08TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME05HTML {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> text = new ArrayList<>();

        while (!input.equals("end of comments")) {
            text.add(input);
            input = scanner.nextLine();
        }

        text.add(0, "<h1>");
        text.add(2, "</h1>");
        text.add(3, "<article>");
        text.add(5, "</article>");

        if (text.size() > 6) {
            text.add("</div>");
        }
        int i = 6;
        while (i < text.size() - 1) {
            text.add(i, "<div>");
            if (i < text.size() - 3) {
                text.add(i + 2, "</div>");
            }
            i += 3;
        }

        for (int j = 0; j < text.size(); j += 3) {
            System.out.println(text.get(j));
            System.out.println("    " + text.get(j + 1));
            System.out.println(text.get(j + 2));
        }

    }
}