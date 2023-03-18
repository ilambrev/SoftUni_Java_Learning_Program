package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {



    @Query(value = "SELECT t FROM Task AS t " +
            "WHERE t.car.carType = 'coupe' " +
            "ORDER BY t.price DESC")
    List<Task> findByPrice();

}