package L01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class L11MultiplicationTable20 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int multiplayer = scanner.nextInt();

        if (multiplayer > 10) {
            System.out.printf("%d X %d = %d", number, multiplayer, number * multiplayer);
        } else {
            for (int i = multiplayer; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", number, i, number * i);
            }
        }
    }
}