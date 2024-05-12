package bg.softuni.L01LinkedOut.web;

import bg.softuni.L01LinkedOut.model.dto.EmployeeCreateDTO;
import bg.softuni.L01LinkedOut.model.еnums.EducationLevelEnum;
import bg.softuni.L01LinkedOut.service.CompanyService;
import bg.softuni.L01LinkedOut.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @GetMapping("/all")
    public String all(Model model) {
        if (!model.containsAttribute("employees")) {
            model.addAttribute("employees", this.employeeService.getAllEmployees());
        }

        return "employee-all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("employeeCreateDTO")) {
            model.addAttribute("employeeCreateDTO", new EmployeeCreateDTO());
        }

        if (!model.containsAttribute("educationLevels")) {
            model.addAttribute("educationLevels", EducationLevelEnum.values());
        }

        if (!model.containsAttribute("companiesNames")) {
            model.addAttribute("companiesNames", this.companyService.getAllCompaniesNames());
        }

        return "employee-add";
    }

    @PostMapping("/add")
    public String add(@Valid EmployeeCreateDTO employeeCreateDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.employeeService.createEmployee(employeeCreateDTO)) {
            redirectAttributes.addFlashAttribute("employeeCreateDTO", employeeCreateDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employeeCreateDTO", bindingResult);

            return "redirect:/employees/add";
        }

        return "redirect:/employees/all";
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable("id") Long id, Model model) {
        if (!model.containsAttribute("employeeDetails")) {
            model.addAttribute("employeeDetails", this.employeeService.getEmployeeById(id));
        }

        return "employee-details";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.employeeService.delete(id);

        return "redirect:/employees/all";
    }
}