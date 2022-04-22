package ME05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME02CarRace {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputNumbers = scanner.nextLine().split(" +");

        List<Integer> raceCheckPoints = new ArrayList<>();
        inputToList(raceCheckPoints, inputNumbers);

        double timeCar1 = 0;
        double timeCar2 = 0;

        for (int i = 0; i < raceCheckPoints.size() / 2; i++) {
            if (raceCheckPoints.get(i) == 0) {
                timeCar1 = timeCar1 * 0.8;
            } else {
                timeCar1 += raceCheckPoints.get(i);
            }
            if (raceCheckPoints.get((raceCheckPoints.size() - 1) - i) == 0) {
                timeCar2 = timeCar2 * 0.8;
            } else {
                timeCar2 += raceCheckPoints.get((raceCheckPoints.size() - 1) - i);
            }
        }

        if (timeCar1 < timeCar2) {
            System.out.printf("The winner is left with total time: %.1f", timeCar1);
        } else if (timeCar1 > timeCar2) {
            System.out.printf("The winner is right with total time: %.1f", timeCar2);
        }
    }

    private static void inputToList(List<Integer> numbersList, String[] inputNumbers) {
        for (int i = 0; i < inputNumbers.length; i++) {
            numbersList.add(Integer.parseInt(inputNumbers[i]));
        }
    }

}