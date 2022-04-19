package ME04Methods;

import java.util.Scanner;

public class ME03LongerLine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());

        findLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);

    }

    private static void findLongerLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double line1 = calculateLineLength(x1, y1, x2, y2);
        double line2 = calculateLineLength(x3, y3, x4, y4);

        if (line1 >= line2) {
            int pointNumber = findCloserPoint(x1, y1, x2, y2);
            if (pointNumber == 1) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1, y1, x2, y2);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2, y2, x1, y1);
            }
        } else {
            int pointNumber = findCloserPoint(x3, y3, x4, y4);
            if (pointNumber == 1) {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x3, y3, x4, y4);
            } else {
                System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x4, y4, x3, y3);
            }
        }
    }

    private static int findCloserPoint(double x1, double y1, double x2, double y2) {
        double firstPointDistance = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double secondPointDistance = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));

        if (firstPointDistance <= secondPointDistance) {
            return 1;
        } else {
            return 2;
        }
    }

    private static double calculateLineLength(double x1, double y1, double x2, double y2) {
        double sideAOfTriangle = 0;
        double sideBOfTriangle = 0;

        if ((x1 >= 0 && x2 >= 0) || (x1 < 0 && x2 < 0)) {
            sideAOfTriangle = Math.abs(x1 - x2);
        } else {
            sideAOfTriangle = Math.abs(x1) + Math.abs(x2);
        }
        if ((y1 >= 0 && y2 >= 0) || (y1 < 0 && y2 < 0)) {
            sideBOfTriangle = Math.abs(y1 - y2);
        } else {
            sideBOfTriangle = Math.abs(y1) + Math.abs(y2);
        }
        return Math.sqrt(Math.pow(sideAOfTriangle, 2) + Math.pow(sideBOfTriangle, 2));
    }

}