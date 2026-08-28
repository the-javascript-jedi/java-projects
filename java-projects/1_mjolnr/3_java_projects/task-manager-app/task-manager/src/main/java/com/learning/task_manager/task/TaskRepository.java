package com.learning.task_manager.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
//    You extend JpaRepository and get these for free:
//
//    findAll() → SELECT * FROM tasks
//    findById(id) → SELECT * FROM tasks WHERE id=?
//    save(task) → INSERT or UPDATE
//    deleteById(id) → DELETE FROM tasks WHERE id=?


//    custom methods for task-specific queries like finding by status:
    List<Task> findByStatus(TaskStatus status);
}


