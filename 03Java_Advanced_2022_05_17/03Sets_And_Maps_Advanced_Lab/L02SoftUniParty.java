package L03SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class L02SoftUniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String guest = scanner.nextLine();

        while (!guest.equals("PARTY")) {
            char guestType = guest.charAt(0);
            if (Character.isDigit(guestType)) {
                vipGuests.add(guest);
            } else {
                regularGuests.add(guest);
            }
            guest = scanner.nextLine();
        }

        String guestToParty = scanner.nextLine();

        while (!guestToParty.equals("END")) {
            char guestType = guestToParty.charAt(0);
            if (Character.isDigit(guestType)) {
                vipGuests.remove(guestToParty);
            } else {
                regularGuests.remove(guestToParty);
            }
            guestToParty = scanner.nextLine();
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        if (!vipGuests.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), vipGuests));
        }
        if (!regularGuests.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), regularGuests));
        }

    }
}