import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class E13RemoveTowns {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String townName = scanner.nextLine();

        int deletedAddressesCount = 0;

        int townID = 0;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query findTownID = em.createQuery("SELECT t FROM Town AS t WHERE t.name LIKE :tn", Town.class)
                .setParameter("tn", townName);

        Town town = (Town) findTownID.getResultStream().findFirst().orElse(null);

        if (town != null) {

            townID = town.getId();

            Query getAddresses = em.createQuery("SELECT a FROM Address AS a WHERE a.town.name LIKE :tn", Address.class)
                    .setParameter("tn", townName);

            List<Address> addressesList = getAddresses.getResultList();

            if (!addressesList.isEmpty()) {

                for (Address address : addressesList) {
                    address.getEmployees().forEach(e -> e.setAddress(null));
                    em.persist(address);
                }

                em.flush();

                Query deleteAddresses = em.createQuery("DELETE FROM Address AS a WHERE a.town.id = :tid")
                        .setParameter("tid", townID);

                deletedAddressesCount = deleteAddresses.executeUpdate();

            }

            Query deleteTown = em.createQuery("DELETE FROM Town AS t WHERE t.id = :tid")
                    .setParameter("tid", townID);

            deleteTown.executeUpdate();

        }

        System.out.printf("%d %s in %s deleted", deletedAddressesCount, deletedAddressesCount == 1 ? "address" : "addresses", townName);

        em.getTransaction().commit();

        em.close();

    }
}