package com.ecommerce.sb_ecom.repositories;

import com.ecommerce.sb_ecom.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}