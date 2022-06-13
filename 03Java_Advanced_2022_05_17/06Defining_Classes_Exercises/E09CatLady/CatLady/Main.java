package CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();


        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] catDetails = input.split("\\s+");
            String breedName = catDetails[0];
            String catName = catDetails[1];
            double characteristic = Double.parseDouble(catDetails[2]);
            Breed breed = new Breed(breedName, characteristic);
            Cat cat = new Cat(catName, breed);
            cats.put(catName, cat);

            input = scanner.nextLine();
        }

        String catName = scanner.nextLine();

        System.out.println(cats.get(catName).toString());

    }
}