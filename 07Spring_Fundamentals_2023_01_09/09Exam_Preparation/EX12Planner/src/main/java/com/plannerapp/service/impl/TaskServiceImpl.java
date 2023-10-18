package com.plannerapp.service.impl;

import com.plannerapp.model.dto.TaskCreateDTO;
import com.plannerapp.model.dto.TaskDTO;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.model.enums.PriorityEnum;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final PriorityRepository priorityRepository;
    private final UserService userService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, PriorityRepository priorityRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        this.userService = userService;
    }

    @Override
    public void addTask(TaskCreateDTO taskCreateDTO) {

        Task task = new Task()
                .setDescription(taskCreateDTO.getDescription())
                .setDueDate(LocalDate.from(taskCreateDTO.getDueDate()))
                .setPriority(this.priorityRepository.findByName(PriorityEnum.valueOf(taskCreateDTO.getPriority())));

        this.taskRepository.save(task);
    }

    @Override
    public List<TaskDTO> getTasksByUserId(Long id) {
        return this.taskRepository.findByUserId(id).stream()
                .map(task -> new TaskDTO()
                        .setId(task.getId())
                        .setDescription(task.getDescription())
                        .setDueDate(task.getDueDate())
                        .setPriority(task.getPriority().getName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTask(Long id) {
        this.taskRepository.deleteById(id);
    }

    @Override
    public void assignTask(Long taskId, Long userId) {
        Optional<Task> taskOptional = this.taskRepository.findById(taskId);

        if (taskOptional.isEmpty()) {
            return;
        }

        Task task = taskOptional.get();

        if (task.getUser() == null) {
            User user = this.userService.getUserById(userId);
            task.setUser(user);
        } else {
            task.setUser(null);
        }

        this.taskRepository.save(task);

    }

}