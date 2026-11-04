package com.learning.movie_manager.movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository{
    //    You extend JpaRepository and get these for free:
//
//    findAll() → SELECT * FROM tasks
//    findById(id) → SELECT * FROM tasks WHERE id=?
//    save(task) → INSERT or UPDATE
//    deleteById(id) → DELETE FROM tasks WHERE id=?
}
