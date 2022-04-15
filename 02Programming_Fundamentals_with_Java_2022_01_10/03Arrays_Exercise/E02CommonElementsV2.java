package E03Arrays;

import java.util.Scanner;

public class E02CommonElementsV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        for (String s : secondArr) {
            for (String f : firstArr) {
                if (s.equals(f)) {
                    System.out.print(s + " ");
                }
            }
        }
    }
}