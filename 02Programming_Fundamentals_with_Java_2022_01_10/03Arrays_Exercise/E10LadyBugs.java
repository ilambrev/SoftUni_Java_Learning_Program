package E03Arrays;

import java.util.Scanner;

public class E10LadyBugs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        String inputIndexes = scanner.nextLine();
        String inputCommand = scanner.nextLine();

        String[] inputArr = inputIndexes.split(" +");

        if (fieldSize > 0) {

            int[] fieldArr = new int[fieldSize];

            for (int i = 0; i < inputArr.length; i++) {
                int testIndex = Integer.parseInt(inputArr[i]);
                if (testIndex >= 0 && testIndex < fieldArr.length) {
                    fieldArr[testIndex] = 1;
                }
            }

            while (!inputCommand.equals("end")) {
                String[] commandArr = inputCommand.split(" +");

                int fieldIndex = Integer.parseInt(commandArr[0]);
                String direction = commandArr[1];
                int movesNumber = Integer.parseInt(commandArr[2]);

                if (movesNumber < 0) {
                    if (direction.equals("left")) {
                        direction = "right";
                    } else if (direction.equals("right")) {
                        direction = "left";
                    }
                    movesNumber = Math.abs(movesNumber);
                }

                if ((fieldIndex >= 0 && fieldIndex < fieldArr.length) && fieldArr[fieldIndex] == 1 && movesNumber > 0) {
                    if (direction.equals("right") && ((fieldIndex + movesNumber) < fieldArr.length)) {
                        int possibleSteps = ((fieldArr.length -1 - fieldIndex) / movesNumber);
                        fieldArr[fieldIndex] = 0;
                        for (int i = 1; i <= possibleSteps; i++) {
                            if (fieldArr[fieldIndex + i * movesNumber] == 0) {
                                fieldArr[fieldIndex + i * movesNumber] = 1;
                                break;
                            }
                        }
                    } else if (direction.equals("left") && (fieldIndex - movesNumber >= 0)) {
                        int possibleSteps = fieldIndex / movesNumber;
                        fieldArr[fieldIndex] = 0;
                        for (int i = 1; i <= possibleSteps; i++) {
                            if (fieldArr[fieldIndex - i * movesNumber] == 0) {
                                fieldArr[fieldIndex - i * movesNumber] = 1;
                                break;
                            }
                        }
                    } else {
                        if (fieldArr[fieldIndex] == 1 && (((fieldIndex + movesNumber) > (fieldArr.length - 1)) || ((fieldIndex - movesNumber) < 0))) {
                            fieldArr[fieldIndex] = 0;
                        }
                    }
                }
                inputCommand = scanner.nextLine();
            }
            for (int j : fieldArr) {
                System.out.print(j + " ");
            }
        }
    }
}