//With DTO
package com.learning.student_api.course;

import com.learning.student_api.dto.CourseResponse;
import com.learning.student_api.dto.CreateCourseRequest;
import com.learning.student_api.dto.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // GET /courses — always returns a list (possibly empty), so no null check needed — 200 OK
    @GetMapping
//    public List<CourseResponse> getAllCourses() {
//        return courseService.getAllCourses();
//    }
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    // GET /courses/1 — single lookup by id can legitimately not exist,
    // so we check for null and return 404 instead of 200 with an empty body — 200 OK or 404 Not Found
    @GetMapping("/{id}")
//    public CourseResponse getCourseById(@PathVariable int id) {
//        return courseService.getCourseById(id);
//    }
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable int id) {
        CourseResponse course = courseService.getCourseById(id);
        if(course==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(course);
    }

    // GET /courses/student/1 — list endpoint again, no null check needed (empty list if student has no courses) — 200 OK
    @GetMapping("/student/{studentId}")
//    public List<CourseResponse> getCoursesByStudent(@PathVariable int studentId) {
//        return courseService.getCoursesByStudent(studentId);
//    }
    public ResponseEntity<List<CourseResponse>> getCoursesByStudent(@PathVariable int studentId) {
       return ResponseEntity.ok(courseService.getCoursesByStudent(studentId));
    }


    // POST /courses/student/1 — service returns null if studentId doesn't exist, so we 404 in that case;
    // otherwise 201 Created (correct status for successfully creating a new resource) — 201 Created or 404 Not Found
    @PostMapping("/student/{studentId}")
//    public CourseResponse createCourse(@PathVariable int studentId, @RequestBody CreateCourseRequest request) {
//        return courseService.createCourse(studentId, request);
//    }
    public ResponseEntity<CourseResponse> createCourse(@PathVariable int studentId, @RequestBody CreateCourseRequest request) {
        CourseResponse course = courseService.createCourse(studentId, request);
        if(course==null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    // PUT /courses/1 — service returns null if the course id doesn't exist, so we 404;
    // otherwise 200 OK with the updated course — 200 OK or 404 Not Found
    @PutMapping("/{id}")
//    public CourseResponse updateCourse(@PathVariable int id, @RequestBody CreateCourseRequest request) {
//        return courseService.updateCourse(id, request);
//    }
    public ResponseEntity<CourseResponse> updateCourse(@PathVariable int id, @RequestBody CreateCourseRequest request) {
        CourseResponse updated = courseService.updateCourse(id, request);
        if (updated==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }


    // DELETE /courses/1 — nothing to send back on success, so we return an empty body — 204 No Content
    @DeleteMapping("/{id}")
//    public void deleteCourse(@PathVariable int id) {
//        courseService.deleteCourse(id);
//    }
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
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