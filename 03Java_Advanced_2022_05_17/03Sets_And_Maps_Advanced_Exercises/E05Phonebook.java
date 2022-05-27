package E03SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E05Phonebook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String contact = scanner.nextLine();

        while (!contact.equals("search")) {
            String[] contactDetails = contact.split("-");
            String name = contactDetails[0];
            String phoneNumber = contactDetails[1];
            phonebook.put(name, phoneNumber);
            contact = scanner.nextLine();
        }

        String searchedContact = scanner.nextLine();

        while (!searchedContact.equals("stop")) {
            if (phonebook.containsKey(searchedContact)) {
                System.out.printf("%s -> %s%n", searchedContact, phonebook.get(searchedContact));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchedContact);
            }
            searchedContact = scanner.nextLine();
        }

    }
}