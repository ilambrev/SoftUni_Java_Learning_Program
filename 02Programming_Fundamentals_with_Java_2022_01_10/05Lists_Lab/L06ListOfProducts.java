package L05Lists;

import java.util.*;

public class L06ListOfProducts {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfProducts = Integer.parseInt(scanner.nextLine());

        List<String> products = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; i++) {
            products.add(scanner.nextLine());
        }

        Collections.sort(products);

        printList(products);
    }

    private static void printList(List<String> numbersList) {
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.println((i + 1) + "." + numbersList.get(i));
        }
    }

}