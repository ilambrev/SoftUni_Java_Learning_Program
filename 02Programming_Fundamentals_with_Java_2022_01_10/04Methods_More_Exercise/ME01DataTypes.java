package ME04Methods;

import java.util.Scanner;

public class ME01DataTypes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String typeOfData = scanner.nextLine();
        String data = scanner.nextLine();

        switch (typeOfData) {
            case "int":
                printResultOfDataManipulation(Integer.parseInt(data));
                break;
            case "real":
                printResultOfDataManipulation(Double.parseDouble(data));
                break;
            case "string":
                printResultOfDataManipulation(data);
                break;
        }
    }

    private static void printResultOfDataManipulation(int input) {
        System.out.println(input * 2);
    }

    private static void printResultOfDataManipulation(double input) {
        System.out.printf("%.2f%n", input * 1.5);
    }

    private static void printResultOfDataManipulation(String input) {
        System.out.printf("$%s$%n", input);
    }

}