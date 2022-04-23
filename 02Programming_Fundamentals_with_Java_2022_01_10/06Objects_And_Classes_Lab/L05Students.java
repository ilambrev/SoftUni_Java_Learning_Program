package L06ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L05Students {

    static class Student {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public int getAge() {
            return this.age;
        }

        public String getHomeTown() {
            return this.homeTown;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();
        List<Student> studentsList = new ArrayList<>();

        while (!inputData.equals("end")) {
            String[] currentStudent = inputData.split("\\s+");
            Student student = new Student(currentStudent[0], currentStudent[1], Integer.parseInt(currentStudent[2]), currentStudent[3]);
            studentsList.add(student);
            inputData = scanner.nextLine();
        }

        String cityName = scanner.nextLine();

        for (Student student : studentsList) {
            if (student.getHomeTown().equals(cityName)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}