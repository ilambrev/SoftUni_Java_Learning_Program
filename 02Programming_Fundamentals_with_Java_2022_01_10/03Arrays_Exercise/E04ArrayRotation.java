package E03Arrays;

import java.util.Scanner;

public class E04ArrayRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        int realRotations = rotations;

        if (realRotations > inputArr.length) {
            //realRotations -= inputArr.length;
            int idleCycles = rotations / inputArr.length;
            realRotations = rotations - (idleCycles * inputArr.length);
        }
        for (int i = 0; i < realRotations; i++) {
            String firstPosition = inputArr[0];
            System.arraycopy(inputArr, 1, inputArr, 0, inputArr.length - 1);
            inputArr[inputArr.length - 1] = firstPosition;
        }
        for(String s : inputArr) {
            System.out.print(s + " ");
        }
    }
}