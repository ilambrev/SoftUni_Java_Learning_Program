package com.plannerapp.controller;

import com.plannerapp.model.dto.TaskCreateDTO;
import com.plannerapp.service.TaskService;
import com.plannerapp.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final CurrentUser currentUser;

    @Autowired
    public TaskController(TaskService taskService, CurrentUser currentUser) {
        this.taskService = taskService;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String getAddTaskForm(Model model) {

        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        if (!model.containsAttribute("taskCreateDTO")) {
            model.addAttribute("taskCreateDTO", new TaskCreateDTO());
        }

        return ("task-add");
    }

    @PostMapping("/add")
    public String addTask(@Valid TaskCreateDTO taskCreateDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskCreateDTO", taskCreateDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskCreateDTO", bindingResult);

            return "redirect:/tasks/add";
        }

        this.taskService.addTask(taskCreateDTO);

        return ("redirect:/home");
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {

        this.taskService.deleteTask(id);

        return "redirect:/home";
    }

    @PatchMapping("/assign/{id}")
    public String assignTask(@PathVariable("id") Long id) {

        this.taskService.assignTask(id, currentUser.getId());

        return "redirect:/home";
    }

}