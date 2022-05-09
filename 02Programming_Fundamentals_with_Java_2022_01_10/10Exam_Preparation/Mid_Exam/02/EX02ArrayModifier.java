package EX02MidExam;

import java.util.Scanner;

public class EX02ArrayModifier {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputValues = scanner.nextLine().split(" ");
        int[] valuesArr = new int[inputValues.length];
        String inputCommand = scanner.nextLine();

        for (int i = 0; i < inputValues.length; i++) {
            valuesArr[i] = Integer.parseInt(inputValues[i]);
        }

        while (!inputCommand.equals("end")) {
            String[] commands = inputCommand.split(" ");
            int index1 = 0;
            int index2 = 0;
            if (commands[0].equals("swap") || commands[0].equals("multiply")) {
                index1 = Integer.parseInt(commands[1]);
                index2 = Integer.parseInt(commands[2]);
            }
            switch (commands[0]) {
                case "swap":
                    if (index1 >= 0 && index1 < valuesArr.length && index2 >= 0 && index2 < valuesArr.length && index1 != index2) {
                        int changeValue = valuesArr[index1];
                        valuesArr[index1] = valuesArr[index2];
                        valuesArr[index2] = changeValue;
                    }
                    break;
                case "multiply":
                    if (index1 >= 0 && index1 < valuesArr.length && index2 >= 0 && index2 < valuesArr.length) {
                        valuesArr[index1] = valuesArr[index1] * valuesArr[index2];
                    }
                    break;
                case "decrease":
                    for (int i = 0; i < valuesArr.length; i++) {
                        valuesArr[i] = valuesArr[i] - 1;
                    }
                    break;
            }

            inputCommand = scanner.nextLine();
        }

        for (int i = 0; i < valuesArr.length; i++) {
            System.out.print(valuesArr[i]);
            if (i < (valuesArr.length - 1)) {
                System.out.print(", ");
            }
        }
    }
}