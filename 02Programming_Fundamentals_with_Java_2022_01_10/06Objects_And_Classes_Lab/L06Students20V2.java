package L06ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L06Students20V2 {

    static class Student {
        String firstName;
        String lastName;
        int age;
        String city;

        Student(String firstName, String lastName, int age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        boolean isFrom(String city) {
            return this.city.equals(city);
        }

        String getInfo() {
            return String.format("%s %s is %d years old", this.firstName, this.lastName, this.age);
        }

        String getFirstName() {
            return this.firstName;
        }

        String getLastName() {
            return this.lastName;
        }

        void setAge(int age) {
            this.age = age;
        }

        void setCity(String city) {
            this.city = city;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        List<Student> students = new ArrayList<>();

        while (!inputLine.equals("end")) {

            String[] studentData = inputLine.split("\\s+");
            String firstName = studentData[0];
            String lastName = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            String city = studentData[3];

            Student existing = findStudent(students, firstName, lastName);
            if (existing == null) {
                students.add(new Student(firstName, lastName, age, city));
            } else {
                existing.setAge(age);
                existing.setCity(city);
            }

            inputLine = scanner.nextLine();
        }

        String city = scanner.nextLine();

        for (Student student : students) {
            if (student.isFrom(city)) {
                System.out.println(student.getInfo());
            }
        }
    }

    private static Student findStudent(List<Student> students, String firstName, String lastName) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                return s;
            }
        }
        return null;
    }

}