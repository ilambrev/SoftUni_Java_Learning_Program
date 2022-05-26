package L03SetsAndMapsAdvanced;

import java.util.*;

public class L05AverageStudentsGrades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int studentsNumber = Integer.parseInt(scanner.nextLine());

        while (studentsNumber-- > 0) {
            String[] studentData = scanner.nextLine().split("\\s+");
            String studentName = studentData[0];
            double studentMark = Double.parseDouble(studentData[1]);
            if (students.containsKey(studentName)) {
                students.get(studentName).add(studentMark);
            } else {
                List<Double> marks = new ArrayList<>();
                marks.add(studentMark);
                students.put(studentName, marks);
            }
        }

        for (String student : students.keySet()) {
            System.out.print(student + " -> ");
            double sumOfMarks = 0;
            int marksNumber = students.get(student).size();
            for (int i = 0; i < marksNumber; i++) {
                double mark = students.get(student).get(i);
                System.out.printf("%.2f ", mark);
                sumOfMarks += mark;
            }
            System.out.printf("(avg: %.2f)%n", sumOfMarks / marksNumber);
        }

    }
}