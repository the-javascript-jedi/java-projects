package com.courses;

import jakarta.persistence.*;

// A JPA "entity" — each instance of this class represents one row in the
// "courses" table. Hibernate reads the annotations below to know how to
// map fields <-> columns, and uses getters/setters to read/write those fields.
@Entity  // tells Hibernate this class maps to a database table
@Table(name = "courses")  // maps to the "courses" table in java_learning DB
public class Courses {

    @Id  // this is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto increment
    private int id;

    @Column(name = "student_id")  // maps to "student_id" column
    private int student_id;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "instructor")
    private String instructor;

    // Default constructor — Hibernate requires this
    public Courses() {}

    public Courses(int student_id, String course_name, String instructor) {
        this.student_id = student_id;
        this.course_name = course_name;
        this.instructor = instructor;
    }

    // Getters — read-only access to each field
    public int getId() { return id; }
    public int getStudentId() { return student_id; }
    public String getCourseName() { return course_name; }
    public String getInstructor() { return instructor; }

    // Setter — a "mutator" method that changes the instructor field on this object.
    // This is what lets you do UPDATEs: change the value in memory with setInstructor(),
    // and Hibernate's dirty-checking notices the field changed and writes it to
    // the DB automatically when the transaction commits (see CourseMain.java line 48).
    public void setInstructor(String updatedInstructor) {
        this.instructor = updatedInstructor;
    }
    @Override
    public String toString() {
        return "Course{id=" + student_id + ", course_name=" + course_name + ", instructor=" + instructor + "}";
    }
}



