package com.learning.student_api.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    // Find all courses for a specific student
    List<Course> findByStudentId(int studentId);
}


