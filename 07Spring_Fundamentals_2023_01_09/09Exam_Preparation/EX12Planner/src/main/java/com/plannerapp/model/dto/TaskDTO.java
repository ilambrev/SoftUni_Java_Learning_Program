package com.plannerapp.model.dto;

import java.time.LocalDate;

public class TaskDTO {

    private Long id;

    private String description;

    private LocalDate dueDate;

    private String priority;

    public TaskDTO() {

    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public TaskDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public TaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskDTO setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getPriority() {
        return priority;
    }

    public TaskDTO setPriority(String priority) {
        this.priority = priority;
        return this;
    }

}