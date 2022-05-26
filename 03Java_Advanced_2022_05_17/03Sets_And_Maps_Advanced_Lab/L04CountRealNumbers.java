package L03SetsAndMapsAdvanced;

import java.util.*;

public class L04CountRealNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> realNumbers = new LinkedHashMap<>();

        double[] tokens = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double token : tokens) {
            if (realNumbers.containsKey(token)) {
                int newValue = realNumbers.get(token) + 1;
                realNumbers.put(token, newValue);
            } else {
                realNumbers.put(token, 1);
            }
        }

        for (Map.Entry<Double, Integer> number : realNumbers.entrySet()) {
            System.out.printf("%.1f -> %d", number.getKey(), number.getValue());
        }

    }
}