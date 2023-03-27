import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;

public class E06AddingANewAddressAndUpdatingEmployee {

    private static final String ADDRESS = "Vitoshka 15";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String employeeLastName = scanner.nextLine();

        Address address = new Address();
        address.setText(ADDRESS);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(address);

        Query updateEmployee = em.createQuery("UPDATE Employee AS e SET e.address = :ad WHERE e.lastName LIKE :ln")
                .setParameter("ad", address)
                .setParameter("ln", employeeLastName);

        updateEmployee.executeUpdate();

        em.getTransaction().commit();

        em.close();

    }
}