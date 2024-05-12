package bg.softuni.L01LinkedOut.service;

import bg.softuni.L01LinkedOut.model.dto.EmployeeCreateDTO;
import bg.softuni.L01LinkedOut.model.dto.EmployeeDTO;
import bg.softuni.L01LinkedOut.model.dto.EmployeeDetailsDTO;

import java.util.List;

public interface EmployeeService {

    boolean createEmployee(EmployeeCreateDTO employeeCreateDTO);

    EmployeeDetailsDTO getEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployees();

    void delete(Long id);
}