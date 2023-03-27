import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class E09FindLatest10Projects {

    private static final String PROJECT_PRINT_FORMAT = "Project name: %s%n" +
            "\t\tProject Description: %s%n" +
            "\t\tProject Start Date:%s%n" +
            "\t\tProject End Date: %s%n";


    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query latestTenProjects = em.createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC", Project.class);

        List<Project> projectsList = latestTenProjects.setMaxResults(10).getResultList();

        projectsList.stream().sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf(PROJECT_PRINT_FORMAT,
                        p.getName(), p.getDescription(),
                        p.getStartDate().minusHours(3).format(formatter),
                        p.getEndDate()));

        em.getTransaction().commit();

        em.close();
    }
}