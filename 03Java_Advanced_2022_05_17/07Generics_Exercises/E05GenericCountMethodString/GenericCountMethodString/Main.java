package GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Box<String> strings = new Box<>();

        int numberOfElements = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfElements; i++) {
            String element = scanner.nextLine();
            strings.add(element);
        }

        String elementToCompare = scanner.nextLine();

        System.out.println(strings.countNumberOfGreaterElements(elementToCompare));

    }
}