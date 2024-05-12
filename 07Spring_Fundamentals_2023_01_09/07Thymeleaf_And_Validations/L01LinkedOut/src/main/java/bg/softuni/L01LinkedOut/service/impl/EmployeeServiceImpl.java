package bg.softuni.L01LinkedOut.service.impl;

import bg.softuni.L01LinkedOut.exception.EmployeeNotFoundException;
import bg.softuni.L01LinkedOut.model.dto.EmployeeCreateDTO;
import bg.softuni.L01LinkedOut.model.dto.EmployeeDTO;
import bg.softuni.L01LinkedOut.model.dto.EmployeeDetailsDTO;
import bg.softuni.L01LinkedOut.model.entity.CompanyEntity;
import bg.softuni.L01LinkedOut.model.entity.EmployeeEntity;
import bg.softuni.L01LinkedOut.repository.EmployeeRepository;
import bg.softuni.L01LinkedOut.service.CompanyService;
import bg.softuni.L01LinkedOut.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CompanyService companyService) {
        this.employeeRepository = employeeRepository;
        this.companyService = companyService;
    }

    @Override
    public boolean createEmployee(EmployeeCreateDTO employeeCreateDTO) {
        CompanyEntity company = this.companyService.getCompanyByName(employeeCreateDTO.getCompanyName());

        EmployeeEntity employee = mapperToEmployeeEntity(employeeCreateDTO, company);

        this.employeeRepository.save(employee);

        return true;
    }

    @Override
    public EmployeeDetailsDTO getEmployeeById(Long id) {
        EmployeeEntity employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id: " + id + "not found!"));

        return mapperToEmployeeDetailsDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return this.employeeRepository.findAll()
                .stream()
                .map(this::mapperToEmployeeDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        this.employeeRepository.deleteById(id);
    }

    private EmployeeEntity mapperToEmployeeEntity(EmployeeCreateDTO employeeCreateDTO, CompanyEntity company) {
        return new EmployeeEntity()
                .setBirthDate(employeeCreateDTO.getBirthDate())
                .setEducationLevel(employeeCreateDTO.getEducationLevel())
                .setFirstName(employeeCreateDTO.getFirstName())
                .setJobTitle(employeeCreateDTO.getJobTitle())
                .setLastName(employeeCreateDTO.getLastName())
                .setSalary(employeeCreateDTO.getSalary())
                .setCompany(company);
    }

    private EmployeeDTO mapperToEmployeeDTO(EmployeeEntity employeeEntity) {
        return new EmployeeDTO()
                .setId(employeeEntity.getId())
                .setFirstName(employeeEntity.getFirstName())
                .setLastName(employeeEntity.getLastName())
                .setJobTitle(employeeEntity.getJobTitle())
                .setBirthDate(employeeEntity.getBirthDate());
    }

    private EmployeeDetailsDTO mapperToEmployeeDetailsDTO(EmployeeEntity employeeEntity) {
        return new EmployeeDetailsDTO()
                .setFirstName(employeeEntity.getFirstName())
                .setLastName(employeeEntity.getLastName())
                .setEducationLevel(employeeEntity.getEducationLevel())
                .setJobTitle(employeeEntity.getJobTitle())
                .setBirthDate(employeeEntity.getBirthDate())
                .setSalary(employeeEntity.getSalary())
                .setCompanyName(employeeEntity.getCompany().getName());
    }
}