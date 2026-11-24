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
@Data
@NoArgsConstructor
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
