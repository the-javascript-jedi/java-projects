package in.javascriptjedi.restapi.service.impl;

import in.javascriptjedi.restapi.dto.ExpenseDTO;
import in.javascriptjedi.restapi.entity.ExpenseEntity;
import in.javascriptjedi.restapi.exceptions.ResourceNotFoundException;
import in.javascriptjedi.restapi.io.ExpenseResponse;
import in.javascriptjedi.restapi.repository.ExpenseRepository;
import in.javascriptjedi.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;

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

    @Override
    public ExpenseDTO getExpenseByExpenseId(String expenseId) {
        ExpenseEntity expenseEntity = getExpenseEntity(expenseId);
       log.info("Printing the expense entity details {}",expenseEntity);
        return mapToExpenseDTO(expenseEntity);
    }

    /**
     * It will delete the single expense details from database
     * @param expenseId
     * @return void
     * */
    @Override
    public void deleteExpenseByExpenseId(String expenseId) {
    ExpenseEntity expenseEntity=getExpenseEntity(expenseId);
    log.info("Printing the expense entity {}",expenseEntity);
    expenseRepository.delete(expenseEntity);
    }
    /**
     *It will save expense details to db
     * @param expenseDTO
     * @return expenseDTO
     * */
    @Override
    public ExpenseDTO saveExpenseDetails(ExpenseDTO expenseDTO) {
       ExpenseEntity newExpenseEntity=mapToExpenseEntity(expenseDTO);
       newExpenseEntity.setExpenseId(UUID.randomUUID().toString());
       newExpenseEntity=expenseRepository.save(newExpenseEntity);
       log.info("Printing the expense entity details {}",newExpenseEntity);
       return mapToExpenseDTO(newExpenseEntity);

    }

    @Override
    public ExpenseDTO updateExpenseDetails(ExpenseDTO expenseDTO, String expenseId) {
        ExpenseEntity existingExpense = getExpenseEntity(expenseId);
        ExpenseEntity updatedExpenseEntity = mapToExpenseEntity((expenseDTO));
        updatedExpenseEntity.setId(existingExpense.getId());
        updatedExpenseEntity.setExpenseId(existingExpense.getExpenseId());
        updatedExpenseEntity.setCreatedAt(existingExpense.getCreatedAt());
        updatedExpenseEntity.setUpdatedAt(existingExpense.getUpdatedAt());
        updatedExpenseEntity=expenseRepository.save(updatedExpenseEntity);
        log.info("Printing the updated expense entity details {}");
        return mapToExpenseDTO(updatedExpenseEntity);
    }

    /**
     *Mapper method to map values from Expense DTO to expense entity
     * @param expenseDTO
     * @return ExpenseEntity
     * */
    private ExpenseEntity mapToExpenseEntity(ExpenseDTO expenseDTO) {
        return modelMapper.map(expenseDTO,ExpenseEntity.class);
    }

    /**
     * mapper method to convert expense entity to expense DTO
     * @param expenseEntity
     * @retyrn ExpenseDTO
     * */
    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
       return modelMapper.map(expenseEntity,ExpenseDTO.class);
    }


    /**
     * Fetch the expense by expense id from db
     * @param expenseId
     * @return ExpenseEntity
     * */
    private ExpenseEntity getExpenseEntity(String expenseId) {
        return expenseRepository.findByExpenseId(expenseId).orElseThrow(
//                run time exception
//                ()->new RuntimeException("Expense not found for the expense id"+expenseId));
//                custom exception
                () -> new ResourceNotFoundException("Expense not found for the expense id" + expenseId));
    }
}
