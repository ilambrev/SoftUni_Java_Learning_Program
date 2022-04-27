package E07MapsLambdaAndStreamAPI;

import java.util.*;

public class E06Courses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] course = input.split(" : ");
            List<String> students = new ArrayList<>();
            if (courses.containsKey(course[0])) {
                students = courses.get(course[0]);
                students.add(course[1]);
            } else {
                students.add(course[1]);
            }
            courses.put(course[0], students);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            List<String> students = entry.getValue();
            System.out.println(entry.getKey() + ": " + students.size());
            for (String student : students) {
                System.out.println("-- " + student);
            }
        }

    }
}