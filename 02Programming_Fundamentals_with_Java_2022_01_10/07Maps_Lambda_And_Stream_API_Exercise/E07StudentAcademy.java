package E07MapsLambdaAndStreamAPI;

import java.util.*;

public class E07StudentAcademy {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfInputs; i++) {
            String studentName = scanner.nextLine();
            double mark = Double.parseDouble(scanner.nextLine());
            List<Double> marks = new ArrayList<>();
            if (students.containsKey(studentName)) {
                marks = students.get(studentName);
                marks.add(mark);
            } else {
                marks.add(mark);
            }
            students.put(studentName, marks);
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            List<Double> marks = entry.getValue();
            double averageGrade = studentAverageGrade(marks);
            if (averageGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrade);
            }
        }

    }

    private static double studentAverageGrade(List<Double> marks) {
        double sumOfMarks = 0;
        for (Double mark : marks) {
            sumOfMarks += mark;
        }
        return sumOfMarks / marks.size();
    }

}