package bg.softuni.ex20230218reseller.controllers;

import bg.softuni.ex20230218reseller.models.dtos.CreateOfferDTO;
import bg.softuni.ex20230218reseller.services.OfferService;
import bg.softuni.ex20230218reseller.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final UserService userService;

    @Autowired
    public OfferController(OfferService offerService, UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @ModelAttribute("createOfferDTO")
    public CreateOfferDTO initCreateProductDTO() {

        return new CreateOfferDTO();
    }

    @GetMapping("/add")
    public String getAddProduct() {

        if (!this.userService.isUserLogged()) {
            return "redirect:/";
        }

        return "offer-add";
    }

    @PostMapping("/add")
    public String postAddProduct(@Valid CreateOfferDTO createOfferDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (!this.userService.isUserLogged()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !this.offerService.add(createOfferDTO)) {
            redirectAttributes.addFlashAttribute("createOfferDTO", createOfferDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);

            return "redirect:/offers/add";
        }

        return "redirect:/home";
    }


    @GetMapping("/remove/{id}")
    public String getRemoveOffer(@PathVariable("id") Long id) {

        if (!this.userService.isUserLogged()) {
            return "redirect:/";
        }

        this.offerService.removeOffer(id);

        return "redirect:/home";
    }

    @GetMapping("/buy/{id}")
    public String getBuyOffer(@PathVariable("id") Long id) {

        if (!this.userService.isUserLogged()) {
            return "redirect:/";
        }

        this.offerService.buyOffer(id);

        return "redirect:/home";
    }

}