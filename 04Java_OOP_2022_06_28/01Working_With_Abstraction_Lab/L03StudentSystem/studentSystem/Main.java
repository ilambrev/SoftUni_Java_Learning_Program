package studentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String command = scanner.nextLine();

        while (!command.equals("Exit")) {
            String[] commandParts = command.split("\\s+");

            studentSystem.ParseCommand(commandParts);

            command = scanner.nextLine();
        }

    }
}