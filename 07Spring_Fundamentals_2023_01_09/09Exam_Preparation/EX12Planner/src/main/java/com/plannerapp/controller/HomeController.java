package com.plannerapp.controller;

import com.plannerapp.model.dto.TaskDTO;
import com.plannerapp.service.TaskService;
import com.plannerapp.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final TaskService taskService;
    private final CurrentUser currentUser;

    @Autowired
    public HomeController(TaskService taskService, CurrentUser currentUser) {
        this.taskService = taskService;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String index() {

        if (currentUser.isLogged()) {
            return "redirect:/home";
        }

        return ("index");
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        List<TaskDTO> assignedToCurrentUserTasks = this.taskService.getTasksByUserId(this.currentUser.getId());
        List<TaskDTO> unassignedTasks = this.taskService.getTasksByUserId(null);

        model.addAttribute("assignedTasks", assignedToCurrentUserTasks);
        model.addAttribute("unassignedTasks", unassignedTasks);

        return ("home");
    }

}