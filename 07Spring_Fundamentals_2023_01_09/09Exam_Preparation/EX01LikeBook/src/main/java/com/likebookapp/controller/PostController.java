package com.likebookapp.controller;

import com.likebookapp.model.dto.PostCreateDTO;
import com.likebookapp.service.PostService;
import com.likebookapp.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final CurrentUser currentUser;

    @Autowired
    public PostController(PostService postService, CurrentUser currentUser) {
        this.postService = postService;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String getPostForm(Model model) {

        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        if (!model.containsAttribute("postCreateDTO")) {
            model.addAttribute("postCreateDTO", new PostCreateDTO());
        }

        return "post-add";
    }

    @PostMapping("/add")
    public String addPost(@Valid PostCreateDTO postCreateDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postCreateDTO", postCreateDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postCreateDTO", bindingResult);

            return "redirect:/posts/add";
        }

        this.postService.addPost(postCreateDTO);

        return "redirect:/home";
    }

    @PatchMapping("/like/{id}")
    public String likePost(@PathVariable("id") Long id) {

        this.postService.likePost(id);


        return "redirect:/home";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {

        this.postService.deletePost(id);

        return "redirect:/home";
    }

}