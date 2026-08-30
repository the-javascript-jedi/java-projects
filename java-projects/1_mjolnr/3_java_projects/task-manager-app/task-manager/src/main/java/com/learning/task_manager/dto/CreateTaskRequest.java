package com.learning.task_manager.dto;

import com.learning.task_manager.task.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Request body for creating a task; validated by Jakarta Bean Validation before reaching the service layer.
public class CreateTaskRequest {
    @NotBlank
    private String title;
    @Size(min = 3, message = "Description must be at least 3 characters")
    private String description;
    private String dueDate;
    private TaskStatus status;

     public String getTitle(){return title;}
    public String getDescription(){return description;}
    public String getDueDate(){return dueDate;}
    public TaskStatus getStatus(){return status;}
}
