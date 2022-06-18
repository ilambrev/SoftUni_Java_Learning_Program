package E02MultidimensionalArrays;

import java.util.Scanner;

public class E09ParkingSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] parkingDimensions = scanner.nextLine().split("\\s+");
        int rows = Short.parseShort(parkingDimensions[0]);
        int cols = Short.parseShort(parkingDimensions[1]);

        byte[][] parkingSpots = new byte[rows][cols];

        String parkRoute = scanner.nextLine();

        while (!parkRoute.equals("stop")) {
            String[] coordinates = parkRoute.split("\\s+");
            int entryRow = Short.parseShort(coordinates[0]);
            int parkingSpotRow = Short.parseShort(coordinates[1]);
            int parkingSpotCol = Short.parseShort(coordinates[2]);

            int distance = 1;
            distance += Math.abs(entryRow - parkingSpotRow);

            if (parkingSpots[parkingSpotRow][parkingSpotCol] == 0) {
                distance += parkingSpotCol;
                parkingSpots[parkingSpotRow][parkingSpotCol] = 1;
                System.out.println(distance);
            } else {
                int closestSpot = findClosestSpot(parkingSpots, cols, parkingSpotRow, parkingSpotCol);
                if (closestSpot == 0) {
                    System.out.println("Row " + parkingSpotRow + " full");
                } else {
                    distance += parkingSpotCol + closestSpot;
                    System.out.println(distance);
                }
            }

            parkRoute = scanner.nextLine();
        }

    }

    private static int findClosestSpot(byte[][] parkingSpots, int cols, int parkingSpotRow, int parkingSpotCol) {
        for (int i = 1; i < cols - 1; i++) {
            if (parkingSpotCol - i > 0 && parkingSpots[parkingSpotRow][parkingSpotCol - i] == 0) {
                parkingSpots[parkingSpotRow][parkingSpotCol - i] = 1;
                return -i;
            } else if (parkingSpotCol + i < cols && parkingSpots[parkingSpotRow][parkingSpotCol + i] == 0) {
                parkingSpots[parkingSpotRow][parkingSpotCol + i] = 1;
                return i;
            }
        }
        return 0;
    }

}