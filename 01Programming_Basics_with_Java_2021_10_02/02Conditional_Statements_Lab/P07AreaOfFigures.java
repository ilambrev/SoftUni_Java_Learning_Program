package conditionalStatements;

import java.util.Scanner;

public class P07AreaOfFigures {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double surface = 0;

        String figure = scanner.nextLine();

        if (figure.equals("square")) {
            double a = Double.parseDouble(scanner.nextLine());
            surface = a * a;
        } else if (figure.equals("rectangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            surface = a * b;
        } else if (figure.equals("circle")) {
            double radius = Double.parseDouble(scanner.nextLine());
            surface = Math.PI * radius * radius;
        } else if (figure.equals("triangle")) {
            double a = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            surface = a * h / 2;
        }
        System.out.printf("%.3f", surface);
    }
}