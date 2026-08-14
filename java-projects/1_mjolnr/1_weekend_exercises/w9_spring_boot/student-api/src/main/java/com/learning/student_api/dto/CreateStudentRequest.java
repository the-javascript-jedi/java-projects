package com.learning.student_api.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 100, message = "Age must be less than 100")
    private int age;

    @Min(value = 0, message = "Grade cannot be negative")
    @Max(value = 100, message = "Grade cannot exceed 100")
    private double grade;

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }
}