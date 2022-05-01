package E08TextProcessing;

import java.util.Scanner;

public class E07StringExplosion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder().append(scanner.nextLine());

        int strength = 0;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '>') {
                strength += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                if (i + strength > input.length() - 1) {
                    strength = input.length() - 1 - i;
                }
                int usedStrength = 0;
                for (int j = 1; j <= strength; j++) {
                    if (input.charAt(i + 1) != '>') {
                        input.deleteCharAt(i + 1);
                        usedStrength++;
                    } else {
                        break;
                    }
                }
                strength -= usedStrength;
            }
        }
        System.out.println(input);
    }
}