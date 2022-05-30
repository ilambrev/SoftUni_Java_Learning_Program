package E03SetsAndMapsAdvanced;

import java.util.*;

public class E06FixEmailsV2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> persons = new LinkedHashMap<>();
        Set<String> undesiredDomains = new HashSet<>(Arrays.asList("us", "uk", "com"));

        String person = scanner.nextLine();

        while (!person.equals("stop")) {
            String email = scanner.nextLine();
            persons.put(person, email);
            person = scanner.nextLine();
        }

        Iterator<String> iterator = persons.keySet().iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            String mail = persons.get(name);
            int domainIndex = mail.lastIndexOf('.');
            String domain = mail.substring(domainIndex + 1);
            if (undesiredDomains.contains(domain)) {
                iterator.remove();
            }
        }

        if (!persons.isEmpty()) {
            for (String name : persons.keySet()) {
                System.out.printf("%s -> %s%n", name, persons.get(name));
            }
        }

    }
}