package L07MapsLambdaAndStreamAPI;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class L01CountRealNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] inputNumbers = scanner.nextLine().split("\\s+");

        Map<Double, Integer> numbersAppearance = new TreeMap<>();

        for (String s : inputNumbers) {
            Double number = Double.parseDouble(s);
            if (numbersAppearance.containsKey(number)) {
                int currentCount = numbersAppearance.get(number);
                numbersAppearance.put(number, currentCount + 1);
            } else {
                numbersAppearance.put(number, 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : numbersAppearance.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}