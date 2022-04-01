package whileLoop;

import java.util.Scanner;

public class P04Sequence2kPlus1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sequence = 1;

        while (sequence <= n) {
            System.out.println(sequence);
            sequence = sequence * 2 + 1;
        }
    }
}