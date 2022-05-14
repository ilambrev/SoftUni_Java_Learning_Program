package EX01FinalExamRetake;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX03ThePianist {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        Map<String, String[]> pieces = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfPieces; i++) {
            String[] piece = scanner.nextLine().split("\\|");
            String[] pieceInfo = new String[]{piece[1], piece[2]};
            pieces.put(piece[0], pieceInfo);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] command = input.split("\\|");
            switch (command[0]) {
                case "Add":
                    if (pieces.containsKey(command[1])) {
                        System.out.printf("%s is already in the collection!%n", command[1]);
                    } else {
                        String[] pieceInfo = new String[]{command[2], command[3]};
                        pieces.put(command[1], pieceInfo);
                        System.out.printf("%s by %s in %s added to the collection!%n", command[1], command[2], command[3]);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(command[1])) {
                        pieces.remove(command[1]);
                        System.out.printf("Successfully removed %s!%n", command[1]);
                    } else
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", command[1]);
                    break;
                case "ChangeKey":
                    if (pieces.containsKey(command[1])) {
                        String[] updateKey = pieces.get(command[1]);
                        updateKey[1] = command[2];
                        pieces.put(command[1], updateKey);
                        System.out.printf("Changed the key of %s to %s!%n", command[1], command[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", command[1]);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, String[]> entry : pieces.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
        }
    }
}