package com.learning.student_api.course;

import com.learning.student_api.student.Student;
import com.learning.student_api.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    // @Autowired tells Spring to automatically create and inject the dependency
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    // GET all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // GET all courses for a specific student
    public List<Course> getCoursesByStudent(int studentId) {
        return courseRepository.findByStudentId(studentId);
    }

    // CREATE a course for a specific student
    public Course createCourse(int studentId, Course course) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;
        course.setStudent(student);
        return courseRepository.save(course);
    }

    // DELETE a course
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}