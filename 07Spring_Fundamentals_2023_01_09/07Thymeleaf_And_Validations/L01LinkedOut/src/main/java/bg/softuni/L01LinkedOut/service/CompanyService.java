package bg.softuni.L01LinkedOut.service;

import bg.softuni.L01LinkedOut.model.dto.CompanyCreateDTO;
import bg.softuni.L01LinkedOut.model.dto.CompanyDTO;
import bg.softuni.L01LinkedOut.model.dto.CompanyDetailsDTO;
import bg.softuni.L01LinkedOut.model.entity.CompanyEntity;

import java.util.List;

public interface CompanyService {

    boolean createCompany(CompanyCreateDTO companyCreateDTO);

    List<CompanyDTO> getAllCompanies();

    CompanyDetailsDTO getCompanyById(Long id);

    void delete(Long id);

    List<String> getAllCompaniesNames();

    CompanyEntity getCompanyByName(String name);
}