package in.javascriptjedi.restapi.repository;

import in.javascriptjedi.restapi.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * JPA repository for Expense Resource
 * */
public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
    /**
     * It will fetch the single expense details from database
     * @param expenseId
     * @return Optional
     * */
    Optional<ExpenseEntity> findByExpenseId(String expenseId);
}
