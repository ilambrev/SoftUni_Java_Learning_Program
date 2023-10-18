package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "priorities")
public class Priority extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private PriorityEnum name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(targetEntity = Task.class, mappedBy = "id")
    private List<Task> tasks;


    public Priority() {

    }

    public Priority(PriorityEnum name) {
        this.name = name;
    }

    public PriorityEnum getName() {
        return name;
    }

    public Priority setName(PriorityEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Priority setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Priority setTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

}