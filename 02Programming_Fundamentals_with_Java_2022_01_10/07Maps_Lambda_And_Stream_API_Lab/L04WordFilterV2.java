package L07MapsLambdaAndStreamAPI;

import java.util.Arrays;
import java.util.Scanner;

public class L04WordFilterV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(w -> w.length() % 2 == 0).toArray(String[]::new);

        for(String s : words) {
            System.out.println(s);
        }
    }
}