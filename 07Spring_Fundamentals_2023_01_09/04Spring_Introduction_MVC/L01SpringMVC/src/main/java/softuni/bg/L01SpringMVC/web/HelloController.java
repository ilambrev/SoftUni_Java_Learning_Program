package softuni.bg.L01SpringMVC.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class HelloController {

    // In browser address bar type -> http://localhost:8080/hello
    @GetMapping
    public String hello(Model model) {

        model.addAttribute("num", 3); // Model

        return "hello-world"; // View
    }

    // In browser address bar type -> http://localhost:8080/hello/param-test?num=45
    @GetMapping("/param-test")
    public String helloWithParam(Model model, @RequestParam("num") Integer num) {

        model.addAttribute("num", num);

        return "hello-world";

    }

    // In browser address bar type -> http://localhost:8080/hello/path-variable/21/test
    @GetMapping("/path-variable/{id}/test")
    public String helloWithPathVariable(Model model, @PathVariable("id") Integer id) {

        model.addAttribute("num", id);

        return "hello-world";

    }

}