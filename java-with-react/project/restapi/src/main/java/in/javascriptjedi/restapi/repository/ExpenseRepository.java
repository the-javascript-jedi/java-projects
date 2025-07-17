package in.javascriptjedi.restapi.repository;

import in.javascriptjedi.restapi.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
    Optional<ExpenseEntity> findByExpenseId(String expenseId);
}
