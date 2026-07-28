package com.learning.student_api.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // GET /courses — get all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // GET /courses/student/1 — get all courses for student with id 1
    @GetMapping("/student/{studentId}")
    public List<Course> getCoursesByStudent(@PathVariable int studentId) {
        return courseService.getCoursesByStudent(studentId);
    }

    // POST /courses/student/1 — add a course to student with id 1
    @PostMapping("/student/{studentId}")
    public Course createCourse(@PathVariable int studentId, @RequestBody Course course) {
        return courseService.createCourse(studentId, course);
    }

    // DELETE /courses/1 — delete course with id 1
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}