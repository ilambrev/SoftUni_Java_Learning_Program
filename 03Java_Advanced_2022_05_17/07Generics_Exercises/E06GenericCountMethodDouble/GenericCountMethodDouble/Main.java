package GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Box<Double> strings = new Box<>();

        int numberOfElements = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfElements; i++) {
            Double element = Double.parseDouble(scanner.nextLine());
            strings.add(element);
        }

        Double elementToCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(strings.countNumberOfGreaterElements(elementToCompare));

    }
}