import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class E10IncreaseSalaries {

    private static final String FIRST_DEPARTMENT_NAME = "Engineering";
    private static final String SECOND_DEPARTMENT_NAME = "Tool Design";
    private static final String THIRD_DEPARTMENT_NAME = "Marketing";
    private static final String FORTH_DEPARTMENT_NAME = "Information Services";

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query getEmployees = em.createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name IN (:d1, :d2, :d3, :d4)", Employee.class)
                .setParameter("d1", FIRST_DEPARTMENT_NAME)
                .setParameter("d2", SECOND_DEPARTMENT_NAME)
                .setParameter("d3", THIRD_DEPARTMENT_NAME)
                .setParameter("d4", FORTH_DEPARTMENT_NAME);

        List<Employee> employeesList = getEmployees.getResultList();

        for (Employee employee : employeesList) {
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            em.persist(employee);
            System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
        }

        em.getTransaction().commit();

        em.close();

    }
}