package E06ObjectsAndClasses;

import java.util.Arrays;
import java.util.Scanner;

public class E05Students {

    static class Student {
        String firstName;
        String lastName;
        double grade;

        double getGrade() {
            return this.grade;
        }

        Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        Student[] students = new Student[numberOfInputs];

        for (int i = 0; i < students.length; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Student student = new Student(input[0], input[1], Double.parseDouble(input[2]));
            students[i] = student;
        }

        Arrays.sort(students, (s2, s1) -> Double.compare(s1.getGrade(), s2.getGrade()));

        for (Student student : students) {
            System.out.println(student);
        }

    }
}