package exam.repository;

import exam.model.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    Optional<Laptop> findByMacAddress(String macAddress);

    @Query(value = "SELECT l FROM Laptop AS l " +
            "ORDER BY l.cpuSpeed DESC, l.ram DESC, l.storage DESC, l.macAddress")
    List<Laptop> findAll();

}