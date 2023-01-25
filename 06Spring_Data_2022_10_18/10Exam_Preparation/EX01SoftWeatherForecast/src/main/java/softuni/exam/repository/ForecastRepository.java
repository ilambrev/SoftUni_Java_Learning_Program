package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.constants.DayOfWeek;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<Forecast> findByCityAndDayOfWeek(City city, DayOfWeek dayOfWeek);

    @Query(value = "SELECT f FROM Forecast AS f " +
            "WHERE f.dayOfWeek = 'SUNDAY' AND f.city.population < 150000 " +
            "ORDER BY f.maxTemperature DESC, f.id")
    List<Forecast> findForecastByCityPopulationAndDay();

}