package com.learning.student_api.student;

import com.learning.student_api.dto.CreateStudentRequest;
import com.learning.student_api.dto.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET /students
    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET /students/1
    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    // POST /students
    @PostMapping
    public StudentResponse createStudent(@RequestBody CreateStudentRequest request) {
        return studentService.createStudent(request);
    }

    // PUT /students/1
    @PutMapping("/{id}")
    public StudentResponse updateStudent(@PathVariable int id, @RequestBody CreateStudentRequest request) {
        return studentService.updateStudent(id, request);
    }

    // DELETE /students/1
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}

// controller without DTOs
//package com.learning.student_api.student;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController  // marks this as a REST API controller
//@RequestMapping("/students")  // all endpoints start with /students
//public class StudentController {
//
//    @Autowired
//    private StudentService studentService;
//
//    // GET /students — returns all students
//    @GetMapping
//    public List<Student> getAllStudents() {
//        return studentService.getAllStudents();
//    }
//
//    // GET /students/1 — returns one student by id
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable int id) {
//        return studentService.getStudentById(id);
//    }
//
//    // POST /students — creates a new student
//    @PostMapping
//    public Student createStudent(@RequestBody Student student) {
//        return studentService.createStudent(student);
//    }
//
//    // PUT /students/1 — updates existing student
//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
//        return studentService.updateStudent(id, student);
//    }
//
//    // DELETE /students/1 — deletes a student
//    @DeleteMapping("/{id}")
//    public void deleteStudent(@PathVariable int id) {
//        studentService.deleteStudent(id);
//    }
//}



