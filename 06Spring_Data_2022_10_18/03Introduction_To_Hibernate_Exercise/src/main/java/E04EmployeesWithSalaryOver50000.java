import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class E04EmployeesWithSalaryOver50000 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query firstName = em.createQuery("SELECT e.firstName FROM Employee AS e WHERE e.salary > 50000", String.class);

        List<String> firstNamesList = firstName.getResultList();

        for (String name : firstNamesList) {
            System.out.println(name);
        }

        em.getTransaction().commit();

        em.close();

    }
}