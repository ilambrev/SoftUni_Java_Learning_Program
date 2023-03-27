import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class E02ChangeCasing_v2 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query townNamesToUpperCase = em.createNativeQuery("UPDATE `towns` AS t" +
                " SET t.`name` = UPPER(t.`name`)" +
                " WHERE CHAR_LENGTH(t.`name`) <= 5");

        townNamesToUpperCase.executeUpdate();

        em.getTransaction().commit();

        em.close();
    }
}