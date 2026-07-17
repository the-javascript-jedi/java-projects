package com.learning;

import jakarta.persistence.*;

@Entity  // tells Hibernate this class maps to a database table
@Table(name = "students")  // maps to the "students" table in java_learning DB
public class Student {

    @Id  // this is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto increment
    private int id;

    @Column(name = "name")  // maps to "name" column
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "grade")
    private double grade;

    // Default constructor — Hibernate requires this
    public Student() {}

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + "}";
    }
}


