package in.javascriptjedi.restapi.repository;

import in.javascriptjedi.restapi.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
}
