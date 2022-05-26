package L03SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L01ParkingLot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String carEntry = scanner.nextLine();

        while (!carEntry.equals("END")) {
            String[] carRecord = carEntry.split(",\\s+");
            String entryType = carRecord[0];
            String carRegNum = carRecord[1];
            if (entryType.equals("IN")) {
                cars.add(carRegNum);
            } else {
                cars.remove(carRegNum);
            }
            carEntry = scanner.nextLine();
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), cars));
        }

    }
}