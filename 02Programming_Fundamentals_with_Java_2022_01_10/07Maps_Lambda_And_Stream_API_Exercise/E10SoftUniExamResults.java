package E07MapsLambdaAndStreamAPI;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E10SoftUniExamResults {

    static class Student {
        String userName;
        int points;
        String state;

        Student(String userName, int points, String state) {
            this.userName = userName;
            this.points = points;
            this.state = state;
        }

        public String getUserName() {
            return this.userName;
        }

        public int getPoints() {
            return this.points;
        }

        public String getState() {
            return this.state;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public void setState(String state) {
            this.state = state;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> languages = new LinkedHashMap<>();
        Map<String, Student> students = new LinkedHashMap<>();

        while (!input.equals("exam finished")) {
            String[] command = input.split("-");
            if (command.length == 2) {
                if (students.containsKey(command[0])) {
                    students.get(command[0]).setState(command[1]);
                }
            } else {
                if (languages.containsKey(command[1])) {
                    languages.put(command[1], languages.get(command[1]) + 1);
                } else {
                    languages.put(command[1], 1);
                }
                if (students.containsKey(command[0])) {
                    if (students.get(command[0]).getPoints() < Integer.parseInt(command[2])) {
                        students.get(command[0]).setPoints(Integer.parseInt(command[2]));
                    }
                } else {
                    students.put(command[0], new Student(command[0], Integer.parseInt(command[2]), "participate"));
                }
            }

            input = scanner.nextLine();
        }

        System.out.println("Results:");

        for (Map.Entry<String, Student> entry : students.entrySet()) {
            if (entry.getValue().getState().equals("participate")) {
                System.out.printf("%s | %d%n", entry.getValue().getUserName(), entry.getValue().getPoints());
            }
        }

        System.out.println("Submissions:");

        for (Map.Entry<String, Integer> entry : languages.entrySet())
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
    }

}