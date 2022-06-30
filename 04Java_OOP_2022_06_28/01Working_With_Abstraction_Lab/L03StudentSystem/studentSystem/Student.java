package studentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String studentInfo() {
        String info = String.format("%s is %s years old.", this.name, this.age);

        if (this.grade >= 5.00) {
            info += " Excellent student.";
        } else if (this.grade < 5.00 && this.grade >= 3.50) {
            info += " Average student.";
        } else {
            info += " Very nice person.";
        }

        return info;
    }

}