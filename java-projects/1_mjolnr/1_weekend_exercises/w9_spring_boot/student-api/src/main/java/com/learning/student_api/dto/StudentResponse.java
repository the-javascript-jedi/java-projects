package com.learning.student_api.dto;

public class StudentResponse {
    private int id;
    private String name;
    private double grade;

    public StudentResponse() {}

    public StudentResponse(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getGrade() { return grade; }
}