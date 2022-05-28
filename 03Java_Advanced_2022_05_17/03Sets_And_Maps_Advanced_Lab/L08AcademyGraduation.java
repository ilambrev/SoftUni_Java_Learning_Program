package L03SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class L08AcademyGraduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Double[]> students = new TreeMap<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= numberOfStudents; i++) {
            String studentName = scanner.nextLine();
            String[] strings = scanner.nextLine().split("\\s+");
            Double[] marks = new Double[strings.length];

            for (int j = 0; j < strings.length; j++) {
                marks[j] = Double.parseDouble(strings[j]);
            }
            students.put(studentName, marks);
        }

        for (var student : students.entrySet()) {
            int marksNumber = student.getValue().length;
            Double marksSum = 0.0;
            for (Double mark : student.getValue()) {
                marksSum += mark;
            }
            String average = String.valueOf(marksSum / marksNumber);
            System.out.printf("%s is graduated with %s%n", student.getKey(), average);
        }

    }
}