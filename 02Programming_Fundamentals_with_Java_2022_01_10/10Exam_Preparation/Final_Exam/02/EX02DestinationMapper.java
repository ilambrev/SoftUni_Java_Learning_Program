package EX02FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EX02DestinationMapper {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([=/])(?<place>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> places = new ArrayList<>();

        int travelPoints = 0;

        while (matcher.find()) {
            places.add(matcher.group("place"));
            travelPoints += matcher.group("place").length();
        }

        System.out.println("Destinations: " + String.join(", ", places));
        System.out.println("Travel Points: " + travelPoints);
    }
}