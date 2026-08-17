//With DTO
package com.learning.student_api.course;

import com.learning.student_api.dto.CourseResponse;
import com.learning.student_api.dto.CreateCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // GET /courses
    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    // GET /courses/1
    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    // GET /courses/student/1
    @GetMapping("/student/{studentId}")
    public List<CourseResponse> getCoursesByStudent(@PathVariable int studentId) {
        return courseService.getCoursesByStudent(studentId);
    }

    // POST /courses/student/1
    @PostMapping("/student/{studentId}")
    public CourseResponse createCourse(@PathVariable int studentId, @RequestBody CreateCourseRequest request) {
        return courseService.createCourse(studentId, request);
    }

    // PUT /courses/1
    @PutMapping("/{id}")
    public CourseResponse updateCourse(@PathVariable int id, @RequestBody CreateCourseRequest request) {
        return courseService.updateCourse(id, request);
    }

    // DELETE /courses/1
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}

// with Entity only no DTO
//package com.learning.student_api.course;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/courses")
//public class CourseController {
//
//    @Autowired
//    private CourseService courseService;
//
//    // GET /courses — get all courses
//    @GetMapping
//    public List<Course> getAllCourses() {
//        return courseService.getAllCourses();
//    }
//
//    // GET /courses/student/1 — get all courses for student with id 1
//    @GetMapping("/student/{studentId}")
//    public List<Course> getCoursesByStudent(@PathVariable int studentId) {
//        return courseService.getCoursesByStudent(studentId);
//    }
//
//    // POST /courses/student/1 — add a course to student with id 1
//    @PostMapping("/student/{studentId}")
//    public Course createCourse(@PathVariable int studentId, @RequestBody Course course) {
//        return courseService.createCourse(studentId, course);
//    }
//
//    // DELETE /courses/1 — delete course with id 1
//    @DeleteMapping("/{id}")
//    public void deleteCourse(@PathVariable int id) {
//        courseService.deleteCourse(id);
//    }
//}