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

    ExpenseDTO getExpenseByExpenseId(String expenseId);
}
