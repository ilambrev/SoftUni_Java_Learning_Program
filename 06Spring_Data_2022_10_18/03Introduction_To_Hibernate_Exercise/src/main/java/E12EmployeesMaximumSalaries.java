import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class E12EmployeesMaximumSalaries {

    public static final BigDecimal beginningOfRange = new BigDecimal(30000);
    public static final BigDecimal endOfRange = new BigDecimal(70000);

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query selectDepartments = em.createQuery("SELECT d FROM Department AS d", Department.class);

        List<Department> departmentsList = selectDepartments.getResultList();

        for (Department department : departmentsList) {

            BigDecimal maxSalary = department.getEmployees().stream()
                    .map(Employee::getSalary)
                    .max(BigDecimal::compareTo)
                    .orElse(BigDecimal.valueOf(0));

            if (maxSalary.compareTo(beginningOfRange) < 0 || maxSalary.compareTo(endOfRange) > 0) {
                System.out.printf("%s %.2f%n", department.getName(), maxSalary);
            }
        }

        em.getTransaction().commit();

        em.close();

    }
}