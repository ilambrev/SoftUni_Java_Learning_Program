package bg.softuni.ex20230218reseller.controllers;

import bg.softuni.ex20230218reseller.models.dtos.OfferDTO;
import bg.softuni.ex20230218reseller.services.OfferService;
import bg.softuni.ex20230218reseller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final OfferService offerService;
    private final UserService userService;

    @Autowired
    public HomeController(OfferService offerService, UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @GetMapping
    public String loggedOutIndex() {

        if (this.userService.isUserLogged()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String loggedInIndex(Model model) {

        if (!this.userService.isUserLogged()) {
            return "redirect:/";
        }

        List<OfferDTO> userOffers = this.userService.getUserOffers();

        model.addAttribute("userOffers", userOffers);

        List<OfferDTO> userBoughtOffers = this.userService.getUsersBoughtOffers();

        model.addAttribute("userBoughtOffers", userBoughtOffers);

        List<OfferDTO> otherUsersOffers = this.offerService.getOtherUsersOffers();

        model.addAttribute("otherUsersOffers", otherUsersOffers);

        return "home";
    }

}