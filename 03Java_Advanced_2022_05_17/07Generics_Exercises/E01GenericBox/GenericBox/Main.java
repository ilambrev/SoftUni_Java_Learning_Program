package GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Box<String> inputData = new Box<>();

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfInputs; i++) {
            String data = scanner.nextLine();
            inputData.add(data);
        }

        System.out.println(inputData);

    }
}