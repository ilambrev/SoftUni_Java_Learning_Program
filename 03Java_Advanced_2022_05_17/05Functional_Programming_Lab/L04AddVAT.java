package L05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class L04AddVAT {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVAT = p -> p * 1.2;

        List<Double> prices = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        System.out.println("Prices with VAT:");

        prices.forEach(p -> System.out.printf("%.2f%n", addVAT.apply(p)));

    }
}