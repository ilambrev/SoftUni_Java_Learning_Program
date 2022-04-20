package L05Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L01SumAdjacentEqualNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String numbersInput = scanner.nextLine();

        List<String> numbersSplit = Arrays.stream(numbersInput.split(" ")).collect(Collectors.toList());
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < numbersSplit.size(); i++) {
            numbers.add(Double.parseDouble(numbersSplit.get(i)));
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals( numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) * 2);
                numbers.remove(i + 1);
                i = -1;
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(new DecimalFormat("0.####").format(numbers.get(i)) + " ");
        }

    }
}