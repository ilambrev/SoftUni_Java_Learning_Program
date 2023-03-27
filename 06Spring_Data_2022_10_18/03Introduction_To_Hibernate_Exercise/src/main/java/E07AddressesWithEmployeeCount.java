import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class E07AddressesWithEmployeeCount {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query getAddresses = em.createQuery("SELECT a FROM Address AS a ORDER BY a.employees.size DESC", Address.class);

        List<Address> addresses = getAddresses.setMaxResults(10).getResultList();

        for (Address address : addresses) {
            System.out.printf("%s, %s - %d employees%n", address.getText(), address.getTown().getName(), address.getEmployees().size());
        }

        em.getTransaction().commit();

        em.close();

    }
}
