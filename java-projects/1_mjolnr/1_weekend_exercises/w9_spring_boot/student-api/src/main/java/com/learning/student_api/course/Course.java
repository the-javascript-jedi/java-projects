package com.learning.student_api.course;

import com.learning.student_api.student.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "instructor")
    private String instructor;

    // Many courses belong to one student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Course() {}

    public Course(String courseName, String instructor, Student student) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.student = student;
    }

    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    public Student getStudent() { return student; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setStudent(Student student) { this.student = student; }
}