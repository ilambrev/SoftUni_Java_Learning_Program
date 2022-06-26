package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bakery {
    public String name;
    public int capacity;
    public List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (this.employees.size() < this.capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee e : this.employees) {
            if (e.getName().equals(name)) {
                employees.remove(e);
                return true;
            }
        }

        return false;
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        for (Employee e : this.employees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }

        return null;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        return String.format("Employees working at Bakery %s:%n", this.name) +
                this.employees.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

}