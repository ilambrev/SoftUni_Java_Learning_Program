package EX02FinalExam;

import java.util.Scanner;

public class EX01WorldTour {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder tourStops = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Travel")) {
            String[] commandParams = command.split(":");
            String commandName = commandParams[0];
            switch (commandName) {
                case "Add Stop":
                    addStop(tourStops, Integer.parseInt(commandParams[1]), commandParams[2]);
                    break;
                case "Remove Stop":
                    removeStop(tourStops, Integer.parseInt(commandParams[1]), Integer.parseInt(commandParams[2]));
                    break;
                case "Switch":
                    changeStop(tourStops, commandParams[1], commandParams[2]);
                    break;
            }
            System.out.println(tourStops);
            command = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + tourStops);
    }

    private static void addStop(StringBuilder tourStops, int index, String string) {
        if (index >= 0 && index < tourStops.length()) {
            tourStops.insert(index, string);
        }
    }

    private static void removeStop(StringBuilder tourStops, int startIndex, int endIndex) {
        if (endIndex >= startIndex && startIndex >= 0 && startIndex < tourStops.length() && endIndex < tourStops.length()) {
            tourStops.delete(startIndex, endIndex + 1);
        }
    }

    private static void changeStop(StringBuilder tourStops, String oldStop, String newStop) {
        String tourStopsToChange = tourStops.toString();
        tourStops.replace(0, tourStops.length(), tourStopsToChange.replace(oldStop, newStop));
    }

}