package com.learning.student_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // No code needed — JpaRepository gives you these for free:
    // save(student)        → INSERT / UPDATE
    // findById(id)         → SELECT WHERE id=?
    // findAll()            → SELECT all
    // deleteById(id)       → DELETE WHERE id=?
    // existsById(id)       → check if row exists
}