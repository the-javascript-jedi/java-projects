package com.ecommerce.sb_ecom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Marks this class as a JPA entity: Hibernate maps it to a database table.
// name="categories" is the entity name (used in JPQL) and, by default, the table name too.
@Entity(name="categories")
// ---- Lombok annotations: generate boilerplate at compile time (you won't see it in the file) ----
// @Data = bundle of 4 things:
//   1. getters for every field      -> getCategoryId(), getCategoryName()
//   2. setters for every field      -> setCategoryId(..), setCategoryName(..)
//      (the service uses setCategoryId() in updateCategory)
//   3. toString()                   -> readable text of the object, handy for logging
//   4. equals() and hashCode()      -> compare two Categories by their field values
//   (Jackson also uses the getters/setters to turn this object to/from JSON.)
@Data
// @NoArgsConstructor -> generates `new Category()` with no parameters.
// REQUIRED: JPA/Hibernate and Jackson both create the object empty first, then fill the fields in.
@NoArgsConstructor
// @AllArgsConstructor -> generates `new Category(categoryId, categoryName)` taking every field.
// Convenient for creating objects quickly in code or tests.
@AllArgsConstructor
public class Category {



    // @Id -> this field is the primary key of the table.
    @Id
    // @GeneratedValue -> the ID is generated automatically, so we don't set it ourselves.
    // GenerationType options (strategy):
    //   IDENTITY -> database auto-increment column (PostgreSQL: SERIAL / identity).
    //               Simple and common; ID is assigned when the row is inserted. <- used here
    //   SEQUENCE -> uses a database sequence object to get the next ID.
    //               Usually the default/preferred choice for PostgreSQL and Oracle;
    //               allows batching inserts efficiently.
    //   AUTO     -> lets Hibernate pick a strategy based on the database (usually SEQUENCE).
    //   TABLE    -> uses a separate table to hold ID counters. Portable but slow; rarely used.
    //   (UUID is also supported in newer JPA versions for random unique IDs.)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;   // primary key -> column "category_id"

    private String categoryName;   // plain column -> "category_name"


}
