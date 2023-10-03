package softuni.bg.L01SpringMVC.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import softuni.bg.L01SpringMVC.model.Dog;

@Controller
@RequestMapping("/dog")
public class DogController {

    @GetMapping
    @ResponseBody
    public Dog getDogHomePage() {
        Dog dog = new Dog().setName("Max").setAge(2).setBreed("Collie");
        return dog;
    }

}