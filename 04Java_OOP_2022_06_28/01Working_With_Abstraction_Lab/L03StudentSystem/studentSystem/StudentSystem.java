package studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public void ParseCommand(String[] commandParts) {
        String commandName = commandParts[0];
        String studentName = commandParts[1];

        if (commandName.equals("Create")) {
            int age = Integer.parseInt(commandParts[2]);
            double grade = Double.parseDouble(commandParts[3]);

            if (!students.containsKey(studentName)) {
                Student student = new Student(studentName, age, grade);
                students.put(studentName, student);
            }

        } else if (commandName.equals("Show")) {

            if (students.containsKey(studentName)) {
                Student student = students.get(studentName);
                System.out.println(student.studentInfo());
            }
        }
    }

}