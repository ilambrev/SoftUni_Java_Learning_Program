package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] pointsCoordinates = getCoordinates(scanner);

        int xA = pointsCoordinates[0];
        int yA = pointsCoordinates[1];
        int xC = pointsCoordinates[2];
        int yC = pointsCoordinates[3];

        Point A = new Point(xA, yA);
        Point C = new Point(xC, yC);

        Rectangle rectangle = new Rectangle(A, C);

        int numberOfPointsToCheck = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfPointsToCheck; i++) {
            int[] pointCoordinates = getCoordinates(scanner);

            int x = pointCoordinates[0];
            int y = pointCoordinates[1];

            Point point = new Point(x, y);

            System.out.println(rectangle.contains(point));
        }

    }

    private static int[] getCoordinates(Scanner scanner) {

        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}