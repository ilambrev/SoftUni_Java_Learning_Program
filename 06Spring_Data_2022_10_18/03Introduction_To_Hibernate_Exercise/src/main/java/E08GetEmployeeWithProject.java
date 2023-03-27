import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.Scanner;

public class E08GetEmployeeWithProject {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int employeeID = scanner.nextInt();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query employeeByID = em.createQuery("SELECT e FROM Employee AS e WHERE e.id = :employeeID", Employee.class)
                        .setParameter("employeeID", employeeID);

        Employee employee = (Employee) employeeByID.getSingleResult();

        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        employee.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.println("      " + p.getName()));

        em.getTransaction().commit();

        em.close();

    }
}