package com.example.todo.controller.task;

import com.example.todo.service.task.TaskEntity;
import com.example.todo.service.task.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskForm (
        @NotBlank
        @Size(max = 256, message = "1-256")
        String summary,

        String description,

        @NotBlank
        String status
){
    public TaskEntity toEntity() {
        return new TaskEntity(null, summary(), description(), TaskStatus.valueOf(status()));
    }
}
