package in.javascriptjedi.restapi.service.impl;

import in.javascriptjedi.restapi.dto.ExpenseDTO;
import in.javascriptjedi.restapi.entity.ExpenseEntity;
import in.javascriptjedi.restapi.repository.ExpenseRepository;
import in.javascriptjedi.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for Expense module
 * */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

//    inject dependencies
    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;
    /**
     * It will fetch the expenses from database
     * @retyrn list
     * */
    @Override
    public List<ExpenseDTO> getAllExpenses() {
        // return List.of();
        // Step 1: Call the repository method
        List<ExpenseEntity> list =expenseRepository.findAll();
        log.info("Printing the data from repository {}",list);
        // Step 2: Convert the Entity object to DTO object
        List<ExpenseDTO> listOfExpenses = list.stream().map(expenseEntity -> mapToExpenseDTO(expenseEntity)).collect(Collectors.toList());
        // Step 3: Return the list
        return listOfExpenses;
    }

    /**
     * mapper method to convert expense entity to expense DTO
     * @param expenseEntity
     * @retyrn ExpenseDTO
     * */
    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
       return modelMapper.map(expenseEntity,ExpenseDTO.class);
    }
}
