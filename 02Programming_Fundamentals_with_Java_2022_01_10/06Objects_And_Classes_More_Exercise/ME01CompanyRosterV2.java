package ME06ObjectsAndClasses;

import java.util.*;

public class ME01CompanyRosterV2 {

    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }

        public double getSalary() {
            return this.salary;
        }

        public String getDepartment() {
            return this.department;
        }

        @Override
        public String toString() {
            return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        Employee[] employees = new Employee[numberOfInputs];
        List<String> departmentsNames = new ArrayList<>();

        for (int i = 0; i < employees.length; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Employee employee;
            if (input.length == 4) {
                employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], "n/a", -1);
            } else if (input.length == 5) {
                if (input[4].contains("@")) {
                    employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4], -1);
                } else {
                    employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], "n/a", Integer.parseInt(input[4]));
                }
            } else {
                employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4], Integer.parseInt(input[5]));
            }

            employees[i] = employee;
        }

        Arrays.sort(employees, (e2, e1) -> Double.compare(e1.getSalary(), e2.getSalary()));

        for (Employee employee : employees) {
            if (!isElementInArray(departmentsNames, employee.getDepartment())) {
                departmentsNames.add(employee.getDepartment());
            }
        }

        double maxAverageSalary = 0;
        String departmentWithHighestSalary = "";

        for (int i = 0; i < departmentsNames.size(); i++) {
            double averageSalary = averageSalary(employees, departmentsNames.get(i));
            if (averageSalary > maxAverageSalary) {
                maxAverageSalary = averageSalary;
                departmentWithHighestSalary = employees[i].getDepartment();
            }
        }

        System.out.printf("Highest Average Salary: %s%n", departmentWithHighestSalary);
        for (Employee e : employees) {
            if (e.getDepartment().equals(departmentWithHighestSalary)) {
                System.out.println(e);
            }
        }
    }

    private static boolean isElementInArray(List<String> departmentsNames, String department) {
        if (!departmentsNames.isEmpty()) {
            for (String d : departmentsNames) {
                if (d.equals(department)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static double averageSalary(Employee[] employees, String department) {
        int departmentEmployees = 0;
        double sumOfSalaries = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                departmentEmployees++;
                sumOfSalaries += employee.getSalary();
            }
        }
        return sumOfSalaries / departmentEmployees;
    }

}