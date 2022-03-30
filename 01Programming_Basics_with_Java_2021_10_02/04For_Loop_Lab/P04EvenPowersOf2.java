package forLoop;

import java.util.Scanner;

public class P04EvenPowersOf2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int powerOfTwo = 1;

        for (int i = 0; i <= num; i += 2) {
            System.out.println(powerOfTwo);
            powerOfTwo = powerOfTwo * 2 * 2;
        }
    }
}