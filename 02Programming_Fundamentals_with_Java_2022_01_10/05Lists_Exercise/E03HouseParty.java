package E05Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03HouseParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        List<String> guestsList = new ArrayList<>();

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] guestStatus = scanner.nextLine().split(" ");
            String guestName = guestStatus[0];
            if (guestStatus[2].equals("going!")) {
                insertGuestInList(guestsList, guestName);
            } else if (guestStatus[2].equals("not")) {
                removeGuestFromList(guestsList, guestName);
            }
        }

        printList(guestsList);
    }

    private static void insertGuestInList(List<String> guestsList, String guestName) {
        boolean isGuestInList = false;
        for (String name : guestsList) {
            if (name.equals(guestName)) {
                isGuestInList = true;
                break;
            }
        }

        if (isGuestInList) {
            System.out.println(guestName + " is already in the list!");
        } else {
            guestsList.add(guestName);
        }
    }

    private static void removeGuestFromList(List<String> guestsList, String guestName) {
        boolean isGuestInList = false;
        for (int i = 0; i < guestsList.size(); i++) {
            if (guestsList.get(i).equals(guestName)) {
                guestsList.remove(i);
                isGuestInList = true;
                break;
            }
        }

        if (!isGuestInList) {
            System.out.println(guestName + " is not in the list!");
        }
    }

    private static void printList(List<String> guestsList) {
        for (String guest : guestsList) {
            System.out.println(guest);
        }
        System.out.println();
    }

}