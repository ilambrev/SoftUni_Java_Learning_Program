import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class E11FindEmployeesByFirstName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.nextLine() + "%";

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query findEmployees = em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName LIKE :pt", Employee.class);

        List<Employee> employeesList = findEmployees.setParameter("pt", pattern).getResultList();

        for (Employee employee : employeesList) {
            System.out.printf("%s %s - %s - ($%.2f)%n",
                    employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary());
        }

        em.getTransaction().commit();

        em.close();

    }
}