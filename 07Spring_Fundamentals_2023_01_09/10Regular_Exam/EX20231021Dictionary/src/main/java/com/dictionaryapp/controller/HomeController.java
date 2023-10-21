package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final WordService wordService;
    private final CurrentUser currentUser;

    @Autowired
    public HomeController(WordService wordService, CurrentUser currentUser) {
        this.wordService = wordService;
        this.currentUser = currentUser;
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (!this.currentUser.isLogged()) {
            return "redirect:/";
        }

        List<WordDTO> germanWords = this.wordService.findAllWordsByLanguage(LanguageName.GERMAN);
        List<WordDTO> spanishWords = this.wordService.findAllWordsByLanguage(LanguageName.SPANISH);
        List<WordDTO> frenchWords = this.wordService.findAllWordsByLanguage(LanguageName.FRENCH);
        List<WordDTO> italianWords = this.wordService.findAllWordsByLanguage(LanguageName.ITALIAN);

        if (!model.containsAttribute("germanWords")) {
            model.addAttribute("germanWords", germanWords);
        }

        if (!model.containsAttribute("spanishWords")) {
            model.addAttribute("spanishWords", spanishWords);
        }

        if (!model.containsAttribute("frenchWords")) {
            model.addAttribute("frenchWords", frenchWords);
        }

        if (!model.containsAttribute("italianWords")) {
            model.addAttribute("italianWords", italianWords);
        }

        if (!model.containsAttribute("contOfAllWords")) {
            model.addAttribute("contOfAllWords", germanWords.size() + spanishWords.size() + frenchWords.size() + italianWords.size());
        }

        return "home";
    }

    @GetMapping("/")
    public String index() {

        if (this.currentUser.isLogged()) {
            return "redirect:/home";
        }

        return "index";
    }

}