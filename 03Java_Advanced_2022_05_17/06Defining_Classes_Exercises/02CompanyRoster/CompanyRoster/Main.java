package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Department> departments = new LinkedHashMap<>();

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfEmployees; i++) {
            String[] employeeInfo = scanner.nextLine().split("\\s+");
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee;
            if (employeeInfo.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (employeeInfo.length == 5) {
                if (employeeInfo[4].matches("\\d+")) {
                    int age = Integer.parseInt(employeeInfo[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    String email = employeeInfo[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else {
                String email = employeeInfo[4];
                int age = Integer.parseInt(employeeInfo[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            Department newDepartment = new Department(department);
            departments.putIfAbsent(department, newDepartment);
            departments.get(department).getEmployees().add(employee);

        }

        String departmentWIthHighAverageSalary = departments.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().departmentAverageSalary()))
                .orElseThrow().getKey();

        System.out.println("Highest Average Salary: " + departmentWIthHighAverageSalary);
        departments.get(departmentWIthHighAverageSalary)
                .getEmployees().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));

    }
}