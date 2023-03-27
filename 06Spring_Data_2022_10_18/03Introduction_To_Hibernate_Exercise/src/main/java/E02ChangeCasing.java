import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class E02ChangeCasing {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query towns = em.createQuery("SELECT t FROM Town AS t", Town.class);

        List<Town> townsList = towns.getResultList();

        for (Town town : townsList) {
            String townName = town.getName();
            if (townName.length() > 5) {
                em.detach(town);
            } else {
                town.setName(townName.toUpperCase());
                em.persist(town);
            }
        }

        em.getTransaction().commit();

        em.close();
    }
}