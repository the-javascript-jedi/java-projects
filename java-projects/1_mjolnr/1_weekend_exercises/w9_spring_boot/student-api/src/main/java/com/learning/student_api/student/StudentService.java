// wth dto
package com.learning.student_api.student;

import com.learning.student_api.dto.CreateStudentRequest;
import com.learning.student_api.dto.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Convert Entity → DTO
    private StudentResponse toDTO(Student student) {
        return new StudentResponse(student.getId(), student.getName(), student.getGrade());
    }

    // GET all students
    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // GET student by id
    public StudentResponse getStudentById(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) return null;
        return toDTO(student);
    }

    // CREATE new student
    public StudentResponse createStudent(CreateStudentRequest request) {
        Student student = new Student(request.getName(), request.getAge(), request.getGrade());
        return toDTO(studentRepository.save(student));
    }

    // UPDATE existing student
    public StudentResponse updateStudent(int id, CreateStudentRequest request) {
        Student existing = studentRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(request.getName());
        existing.setAge(request.getAge());
        existing.setGrade(request.getGrade());
        return toDTO(studentRepository.save(existing));
    }

    // DELETE student
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
//// code without dto
//package com.learning.student_api.student;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class StudentService {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    // GET all students
//    public List<Student> getAllStudents() {
//        return studentRepository.findAll();
//    }
//
//    // GET student by id
//    public Student getStudentById(int id) {
//        return studentRepository.findById(id).orElse(null);
//    }
//
//    // CREATE new student
//    public Student createStudent(Student student) {
//        return studentRepository.save(student);
//    }
//
//    // UPDATE existing student
//    public Student updateStudent(int id, Student updatedStudent) {
//        Student existing = studentRepository.findById(id).orElse(null);
//        if (existing == null) return null;
//        existing.setName(updatedStudent.getName());
//        existing.setAge(updatedStudent.getAge());
//        existing.setGrade(updatedStudent.getGrade());
//        return studentRepository.save(existing);
//    }
//
//    // DELETE student
//    public void deleteStudent(int id) {
//        studentRepository.deleteById(id);
//    }
//}



