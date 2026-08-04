package com.learning.student_api.dto;

public class CreateStudentRequest {
    private String name;
    private int age;
    private double grade;

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }
}