package softuni.bg.L01SpringMVC.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.bg.L01SpringMVC.model.UserDTO;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String newUser() {

        return "new-user";
    }

    @PostMapping
    public String createUser(UserDTO userDTO, Model model) {

        System.out.println("Creating new user... " + userDTO);

        model.addAttribute("name", userDTO.getFirstName() + " " + userDTO.getLastName());

        return "user-created";
    }

}