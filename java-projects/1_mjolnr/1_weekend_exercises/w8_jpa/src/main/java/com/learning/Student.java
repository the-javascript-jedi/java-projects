package com.learning;

import jakarta.persistence.*;

// A JPA "entity" — each instance of this class represents one row in the
// "students" table. Hibernate reads the annotations below to know how to
// map fields <-> columns, and uses getters/setters to read/write those fields.
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

    // Getters — read-only access to each field
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }

    // Setter — a "mutator" method that changes the grade field on this object.
    // This is what lets you do UPDATEs: change the value in memory with setGrade(),
    // and Hibernate's dirty-checking notices the field changed and writes it to
    // the DB automatically when the transaction commits (see Main.java line 33).
    public void setGrade(double grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Student{id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + "}";
    }
}


