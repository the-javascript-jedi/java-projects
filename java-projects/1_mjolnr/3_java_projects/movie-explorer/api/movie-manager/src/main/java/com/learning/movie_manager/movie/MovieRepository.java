package com.learning.movie_manager.movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

// REPOSITORY LAYER = the only layer that talks to the database.
// @Repository = marks this as a data-access component so Spring manages it.
//
// "interface" (not class): you only declare WHAT you want. Spring Data JPA writes the actual
// implementation (the SQL code) at startup. You never write the SQL for the basic operations.
//
// JpaRepository<Movie, Long> = generics:
//   Movie = the entity (table) this repository manages
//   Long  = the type of the primary key (@Id) field in Movie
// Without these <...> types, findAll() would return plain Objects and toDto(Movie) would not compile.
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{
    //    You extend JpaRepository and get these for free:
//
//    findAll() → SELECT * FROM tasks
//    findById(id) → SELECT * FROM tasks WHERE id=?
//    save(task) → INSERT or UPDATE
//    deleteById(id) → DELETE FROM tasks WHERE id=?
//    (In this project the table is movies_list, not tasks.)
}