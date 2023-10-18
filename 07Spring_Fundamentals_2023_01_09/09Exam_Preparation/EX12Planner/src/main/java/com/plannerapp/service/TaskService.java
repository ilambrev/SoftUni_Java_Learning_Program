package com.plannerapp.service;

import com.plannerapp.model.dto.TaskCreateDTO;
import com.plannerapp.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    void addTask(TaskCreateDTO taskCreateDTO);

    List<TaskDTO> getTasksByUserId(Long id);

    void deleteTask(Long id);

    void assignTask(Long taskId, Long userId);

}