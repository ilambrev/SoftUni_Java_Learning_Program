package E03SetsAndMapsAdvanced;

import java.util.*;

public class E06FixEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> persons = new LinkedHashMap<>();
        Set<String> undesiredDomains = new HashSet<>(Arrays.asList("us", "uk", "com"));

        String person = scanner.nextLine();

        while (!person.equals("stop")) {
            String email = scanner.nextLine();
            int domainIndex = email.lastIndexOf('.');
            String domain = email.substring(domainIndex + 1);
            if (!undesiredDomains.contains(domain)) {
                persons.put(person, email);
            }
            person = scanner.nextLine();
        }

        if (!persons.isEmpty()) {
            for (String name : persons.keySet()) {
                System.out.printf("%s -> %s%n", name, persons.get(name));
            }
        }

    }
}