import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class E05EmployeesFromDepartment {

    private static final String DEPARTMENT_NAME = "Research and Development";

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query employeesFromDepartment = em.createQuery(
                        "SELECT e FROM Employee AS e " +
                                "WHERE e.department.name LIKE :did " +
                                "ORDER BY e.salary ASC, e.id ASC", Employee.class)
                .setParameter("did", DEPARTMENT_NAME);

        List<Employee> employeesList = employeesFromDepartment.getResultList();

        for (Employee employee : employeesList) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    employee.getFirstName(), employee.getLastName(), employee.getDepartment().getName(), employee.getSalary());
        }

        em.getTransaction().commit();

        em.close();

    }
}