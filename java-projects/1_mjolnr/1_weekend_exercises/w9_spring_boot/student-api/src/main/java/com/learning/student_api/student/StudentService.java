package com.learning.student_api.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // GET all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET student by id
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // CREATE new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // UPDATE existing student
    public Student updateStudent(int id, Student updatedStudent) {
        Student existing = studentRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setName(updatedStudent.getName());
        existing.setAge(updatedStudent.getAge());
        existing.setGrade(updatedStudent.getGrade());
        return studentRepository.save(existing);
    }

    // DELETE student
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}