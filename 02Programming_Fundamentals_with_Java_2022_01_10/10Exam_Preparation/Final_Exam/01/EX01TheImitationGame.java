package EX01FinalExamRetake;

import java.util.Scanner;

public class EX01TheImitationGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String command = scanner.nextLine();
        StringBuilder decodedMessage = new StringBuilder();
        decodedMessage.append(message);

        while (!command.equals("Decode")) {
            String[] operations = command.split("\\|");
            switch (operations[0]) {
                case "Move":
                    if (Integer.parseInt(operations[1]) < decodedMessage.length()) {
                        String moveString = decodedMessage.substring(0, Integer.parseInt(operations[1]));
                        decodedMessage.append(moveString);
                        decodedMessage.delete(0,Integer.parseInt(operations[1]));
                    }
                    break;
                case "Insert":
                    if (Integer.parseInt(operations[1]) >= 0 && Integer.parseInt(operations[1]) <= decodedMessage.length()) {
                    decodedMessage.insert(Integer.parseInt(operations[1]), operations[2]);
                    }
                    break;
                case "ChangeAll":
                    while (decodedMessage.indexOf(operations[1]) > -1) {
                        int startIndex = decodedMessage.indexOf(operations[1]);
                        int endIndex = startIndex + operations[1].length();
                        decodedMessage.replace(startIndex, endIndex, operations[2]);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s%n", decodedMessage);
    }
}