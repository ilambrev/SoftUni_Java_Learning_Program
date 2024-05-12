package bg.softuni.L01LinkedOut.service.impl;

import bg.softuni.L01LinkedOut.exception.CompanyNotFoundException;
import bg.softuni.L01LinkedOut.model.dto.CompanyCreateDTO;
import bg.softuni.L01LinkedOut.model.dto.CompanyDTO;
import bg.softuni.L01LinkedOut.model.dto.CompanyDetailsDTO;
import bg.softuni.L01LinkedOut.model.entity.CompanyEntity;
import bg.softuni.L01LinkedOut.repository.CompanyRepository;
import bg.softuni.L01LinkedOut.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean createCompany(CompanyCreateDTO companyCreateDTO) {
        CompanyEntity company = mapperToCompanyEntity(companyCreateDTO);

        this.companyRepository.save(company);

        return true;
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        return this.companyRepository.findAll()
                .stream()
                .map(this::mapperToCompanyDTO)
                .toList();
    }

    @Override
    public CompanyDetailsDTO getCompanyById(Long id) {
        CompanyEntity company = this.companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException("Company with id: " + id + "not found!"));

        return mapperToCompanyDetailsDTO(company);
    }

    @Override
    public void delete(Long id) {
        this.companyRepository.deleteById(id);
    }

    @Override
    public List<String> getAllCompaniesNames() {
        return this.companyRepository.findAllByOrderByNameAsc()
                .stream()
                .map(CompanyEntity::getName)
                .toList();
    }

    @Override
    public CompanyEntity getCompanyByName(String name) {
        return this.companyRepository.findByName(name);
    }

    private CompanyEntity mapperToCompanyEntity(CompanyCreateDTO companyCreateDTO) {
        return new CompanyEntity()
                .setBudget(companyCreateDTO.getBudget())
                .setDescription(companyCreateDTO.getDescription())
                .setName(companyCreateDTO.getName())
                .setTown(companyCreateDTO.getTown());
    }

    private CompanyDTO mapperToCompanyDTO(CompanyEntity company) {
        return new CompanyDTO()
                .setId(company.getId())
                .setName(company.getName())
                .setTown(company.getTown())
                .setDescription(company.getDescription().substring(0, Math.min(5, company.getDescription().length())));
    }

    private CompanyDetailsDTO mapperToCompanyDetailsDTO(CompanyEntity company) {
       return new CompanyDetailsDTO()
                .setId(company.getId())
                .setName(company.getName())
                .setTown(company.getTown())
                .setDescription(company.getDescription())
                .setBudget(company.getBudget());
    }
}