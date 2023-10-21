package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.WordCreateDTO;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.CurrentUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/words")
public class WordsController {

    private final WordService wordService;
    private final CurrentUser currentUser;

    @Autowired
    public WordsController(WordService wordService, CurrentUser currentUser) {
        this.wordService = wordService;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String getAddWordForm(Model model) {

        if (!this.currentUser.isLogged()) {
            return "redirect:/";
        }

        if (!model.containsAttribute("wordCreateDTO")) {
            model.addAttribute("wordCreateDTO", new WordCreateDTO());
        }

        return "word-add";
    }

    @PostMapping("/add")
    public String addWord(@Valid WordCreateDTO wordCreateDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (!this.currentUser.isLogged()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("wordCreateDTO", wordCreateDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.wordCreateDTO", bindingResult);

            return "redirect:/words/add";
        }

        this.wordService.addWord(wordCreateDTO);

        return "redirect:/home";
    }

    @DeleteMapping("/delete/all")
    public String deleteAll() {

        if (!this.currentUser.isLogged()) {
            return "redirect:/";
        }

        this.wordService.deleteAllWords();

        return "redirect:/home";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteWordById(@PathVariable("id") Long id) {

        if (!this.currentUser.isLogged()) {
            return "redirect:/";
        }

        this.wordService.deleteWordById(id);

        return "redirect:/home";
    }

}