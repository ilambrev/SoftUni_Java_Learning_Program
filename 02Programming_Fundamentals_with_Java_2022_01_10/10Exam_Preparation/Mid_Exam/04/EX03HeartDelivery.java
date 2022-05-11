package EX04MidExam;

import java.util.Scanner;

public class EX03HeartDelivery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] neighborhoodHouses = inputStringToInt(scanner);
        String inputCommands = scanner.nextLine();

        int index = 0;
        while (!inputCommands.equals("Love!")) {
            String[] commands = inputCommands.split("\\s+");
            int jump = Integer.parseInt(commands[1]);
            index += jump;
            if ((index) > neighborhoodHouses.length - 1) {
                index = 0;
            }
            if (neighborhoodHouses[index] != 0) {
                neighborhoodHouses[index] -= 2;
                if (neighborhoodHouses[index] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", index);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", index);
            }

            inputCommands = scanner.nextLine();
        }

        int cupidFails = countCupidFails(neighborhoodHouses);

        System.out.printf("Cupid's last position was %d.%n", index);
        if (cupidFails == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", cupidFails);
        }

    }

    private static int[] inputStringToInt(Scanner scanner) {
        String[] inputToNumber = scanner.nextLine().split("@+");
        int[] numbersArr = new int[inputToNumber.length];
        for (int i = 0; i < inputToNumber.length; i++) {
            numbersArr[i] = Integer.parseInt(inputToNumber[i]);
        }
        return numbersArr;
    }

    private static int countCupidFails(int[] numberArr) {
        int fails = 0;
        for (int i = 0; i < numberArr.length; i++) {
            if (numberArr[i] != 0) {
                fails++;
            }
        }
        return fails;
    }

}