package ME08TextProcessing;

import java.util.Scanner;

public class ME03TreasureFinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] keysString = (scanner.nextLine()).split("\\s+");

        int[] keys = new int[keysString.length];

        for (int i = 0; i < keys.length; i++) {
            keys[i] = Integer.parseInt(keysString[i]);
        }

        String input = scanner.nextLine();

        while (!input.equals("find")) {
            StringBuilder text = new StringBuilder();
            int keyCounter = 0;
            for (int i = 0; i < input.length(); i++) {
                text.append((char) (input.charAt(i) - keys[keyCounter]));
                keyCounter++;
                if (keyCounter > keys.length - 1) {
                    keyCounter = 0;
                }
            }
            String treasure = text.substring(text.indexOf("&") + 1, text.lastIndexOf("&"));
            String coordinates = text.substring(text.indexOf("<") + 1, text.indexOf(">"));

            System.out.printf("Found %s at %s%n", treasure, coordinates);
            input = scanner.nextLine();
        }

    }
}