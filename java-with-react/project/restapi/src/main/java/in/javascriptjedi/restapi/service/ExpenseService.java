package in.javascriptjedi.restapi.service;

import in.javascriptjedi.restapi.dto.ExpenseDTO;

import java.util.List;
/**
 * Service interface for Expense module
 * */
public interface ExpenseService {

    /**
     * It will fetch the expenses from database
     * @return list
     * */
    List<ExpenseDTO> getAllExpenses();
    /**
     * It will fetch the single expense details from database
     * @param expenseId
     * @return ExpenseDTO
     * */
    ExpenseDTO getExpenseByExpenseId(String expenseId);

    /**
     * It will delete the single expense details from database
     * @param expenseId
     * @return void
     * */
    void deleteExpenseByExpenseId(String expenseId);
}
