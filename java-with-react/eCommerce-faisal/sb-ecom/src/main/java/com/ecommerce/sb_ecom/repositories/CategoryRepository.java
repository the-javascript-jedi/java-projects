package com.ecommerce.sb_ecom.repositories;

import com.ecommerce.sb_ecom.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// The data-access layer. It's just an interface with NO code: Spring Data JPA generates
// the implementation at startup, so there's no SQL to write by hand.
// JpaRepository<Category, Long> -> <the entity it manages, the type of its primary key>.
// Extending it gives us ready-made methods such as:
//   findAll()      -> SELECT * FROM categories
//   findById(id)   -> SELECT ... WHERE category_id = ?   (returns an Optional)
//   save(entity)   -> INSERT if the id is null, UPDATE if the id exists
//   delete(entity) -> DELETE ... WHERE category_id = ?
// No @Repository needed: Spring detects it automatically because it extends JpaRepository.
public interface CategoryRepository extends JpaRepository<Category,Long> {

}