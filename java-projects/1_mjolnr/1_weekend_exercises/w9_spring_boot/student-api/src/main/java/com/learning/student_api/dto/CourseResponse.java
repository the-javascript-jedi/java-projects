package com.learning.student_api.dto;

public class CourseResponse {
    private int id;
    private String courseName;
    private String instructor;
    private String studentName; // just the name, not the full Student object

    public CourseResponse() {}

    public CourseResponse(int id, String courseName, String instructor, String studentName) {
        this.id = id;
        this.courseName = courseName;
        this.instructor = instructor;
        this.studentName = studentName;
    }

    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    public String getStudentName() { return studentName; }
}


