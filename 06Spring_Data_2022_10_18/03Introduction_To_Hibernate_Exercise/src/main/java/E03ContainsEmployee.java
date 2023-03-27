import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class E03ContainsEmployee {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] employeeName = scanner.nextLine().split("\\s+");

        String firstName = employeeName[0];
        String lastName = employeeName[1];

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        long matches = em.createQuery(
                "SELECT COUNT(e) FROM Employee AS e WHERE e.firstName LIKE :fn AND e.lastName LIKE :ln", Long.class)
                .setParameter("fn", firstName)
                .setParameter("ln", lastName)
                .getSingleResult();

        System.out.println(matches == 0 ? "No" : "Yes");

        em.getTransaction().commit();

        em.close();

    }
}