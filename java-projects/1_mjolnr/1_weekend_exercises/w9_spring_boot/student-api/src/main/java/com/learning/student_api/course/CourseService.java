// With DTO
package com.learning.student_api.course;

import com.learning.student_api.dto.CourseResponse;
import com.learning.student_api.dto.CreateCourseRequest;
import com.learning.student_api.student.Student;
import com.learning.student_api.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Convert Entity → DTO
    private CourseResponse toDTO(Course course) {
        return new CourseResponse(
                course.getId(),
                course.getCourseName(),
                course.getInstructor(),
                course.getStudent().getName()
        );
    }

    // GET all courses
    // SQL: SELECT c.id, c.course_name, c.instructor, c.student_id FROM courses c
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // GET course by id
    // SQL: SELECT c.id, c.course_name, c.instructor, c.student_id FROM courses c WHERE c.id = ?
    public CourseResponse getCourseById(int id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) return null;
        return toDTO(course);
    }

    // GET all courses for a specific student
    // SQL: SELECT c.id, c.course_name, c.instructor, c.student_id FROM courses c WHERE c.student_id = ?
    public List<CourseResponse> getCoursesByStudent(int studentId) {
        return courseRepository.findByStudentId(studentId)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // CREATE a course for a specific student
    public CourseResponse createCourse(int studentId, CreateCourseRequest request) {
        // SQL: SELECT s.id, s.name, s.age, s.grade FROM students s WHERE s.id = ?
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;
        Course course = new Course(request.getCourseName(), request.getInstructor(), student);
        // SQL: INSERT INTO courses (course_name, instructor, student_id) VALUES (?, ?, ?)
        return toDTO(courseRepository.save(course));
    }

    // UPDATE a course
    public CourseResponse updateCourse(int id, CreateCourseRequest request) {
        // SQL: SELECT c.id, c.course_name, c.instructor, c.student_id FROM courses c WHERE c.id = ?
        Course existing = courseRepository.findById(id).orElse(null);
        if (existing == null) return null;
        existing.setCourseName(request.getCourseName());
        existing.setInstructor(request.getInstructor());
        // SQL: UPDATE courses SET course_name = ?, instructor = ? WHERE id = ?
        // (save() on an already-persisted entity triggers an UPDATE, not an INSERT)
        return toDTO(courseRepository.save(existing));
    }

    // DELETE a course
    // SQL: DELETE FROM courses WHERE id = ?
    // (findById is also called first internally by deleteById to check existence)
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}


// Without DTO
//package com.learning.student_api.course;
//
//import com.learning.student_api.student.Student;
//import com.learning.student_api.student.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CourseService {
//
//    // @Autowired tells Spring to automatically create and inject the dependency
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    // GET all courses
//    public List<Course> getAllCourses() {
//        return courseRepository.findAll();
//    }
//
//    // GET all courses for a specific student
//    public List<Course> getCoursesByStudent(int studentId) {
//        return courseRepository.findByStudentId(studentId);
//    }
//
//    // CREATE a course for a specific student
//    public Course createCourse(int studentId, Course course) {
//        Student student = studentRepository.findById(studentId).orElse(null);
//        if (student == null) return null;
//        course.setStudent(student);
//        return courseRepository.save(course);
//    }
//
//    // DELETE a course
//    public void deleteCourse(int id) {
//        courseRepository.deleteById(id);
//    }
//}

