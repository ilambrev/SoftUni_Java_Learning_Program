package listyIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ListyIterator<String> listyIterator = new ListyIterator<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commandParts = input.split("\\s+");
            String command = commandParts[0];

            switch (command) {
                case "Create":
                    if (commandParts.length > 1) {
                        String[] arguments = new String[commandParts.length - 1];
                        System.arraycopy(commandParts, 1, arguments, 0, commandParts.length - 1);
                        listyIterator = new ListyIterator<>(arguments);
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
            }

            input = scanner.nextLine();
        }

    }
}