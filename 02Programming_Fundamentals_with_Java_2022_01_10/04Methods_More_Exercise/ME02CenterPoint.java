package ME04Methods;

import java.util.Scanner;

public class ME02CenterPoint {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        findCloserPoint(x1, y1, x2, y2);
    }

    private static void findCloserPoint(double x1, double y1, double x2, double y2) {
        double firstPointDistance = calculateDistance(x1, y1);
        double secondPointDistance = calculateDistance(x2, y2);

        if (firstPointDistance <= secondPointDistance) {
            System.out.printf("(%.0f, %.0f)", x1, y1);
        } else {
            System.out.printf("(%.0f, %.0f)", x2, y2);
        }
    }

    private static double calculateDistance(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

}