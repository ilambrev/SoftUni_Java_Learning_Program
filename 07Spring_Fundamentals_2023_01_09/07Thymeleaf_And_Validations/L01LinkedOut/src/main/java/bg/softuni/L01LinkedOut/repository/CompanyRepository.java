package bg.softuni.L01LinkedOut.repository;

import bg.softuni.L01LinkedOut.model.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    List<CompanyEntity> findAllByOrderByNameAsc();

    CompanyEntity findByName(String name);
}