package bg.softuni.L01LinkedOut.web;

import bg.softuni.L01LinkedOut.model.dto.CompanyCreateDTO;
import bg.softuni.L01LinkedOut.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/all")
    public String all(Model model) {
        if (!model.containsAttribute("companies")) {
            model.addAttribute("companies", this.companyService.getAllCompanies());
        }

        return "company-all";
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("companyCreateDTO")) {
            model.addAttribute("companyCreateDTO", new CompanyCreateDTO());
        }

        return "company-add";
    }

    @PostMapping("/add")
    public String add(@Valid CompanyCreateDTO companyCreateDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.companyService.createCompany(companyCreateDTO)) {
            redirectAttributes.addFlashAttribute("companyCreateDTO", companyCreateDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.companyCreateDTO", bindingResult);

            return "redirect:/companies/add";
        }

        return "redirect:/companies/all";
    }

    @GetMapping("/{id}/details")
    public String details(@PathVariable("id") Long id, Model model) {
        if (!model.containsAttribute("companyDetails")) {
            model.addAttribute("companyDetails", this.companyService.getCompanyById(id));
        }

        return "company-details";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.companyService.delete(id);

        return "redirect:/companies/all";
    }
}