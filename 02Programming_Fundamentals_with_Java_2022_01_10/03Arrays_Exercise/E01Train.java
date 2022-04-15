package E03Arrays;

import java.util.Scanner;

public class E01Train {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputsNumber = Integer.parseInt(scanner.nextLine());

        int[] trainArr = new int[inputsNumber];

        int peopleNumber = 0;

        for (int i = 0; i < trainArr.length; i++) {
            trainArr[i] = Integer.parseInt(scanner.nextLine());
            peopleNumber += trainArr[i];
            System.out.print(trainArr[i] + " ");
        }

        System.out.println("\n" + peopleNumber);
    }
}