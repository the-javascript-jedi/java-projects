package in.javascriptjedi.restapi.controller;
import in.javascriptjedi.restapi.dto.ExpenseDTO;
import in.javascriptjedi.restapi.io.ExpenseRequest;
import in.javascriptjedi.restapi.io.ExpenseResponse;
import in.javascriptjedi.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is Controller Class for Expense Module
 * */
@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;
    /**
     * It will fetch the expenses from database
     * @return list
     * */
    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses(){
        log.info("API GET /expenses called");
        // Call the service method
        List<ExpenseDTO> list = expenseService.getAllExpenses();
        log.info("Printing the data from service {}",list);
        // Convert the Expense DTO to Expense Response
        List<ExpenseResponse> response=list.stream().map(
                expenseDTO -> mapToExpenseResponse(expenseDTO)
                ).collect(Collectors.toList());
        // Return the list/response
        return response;
    }

    // Testing an API
    //    @GetMapping("/expenses/{expenseId}")
    //    public String getExpenseById(@PathVariable String expenseId){
    //        log.info("Printing the expense id{}",expenseId);
    //        return "Printing the expense id "+expenseId;
    //    }
    /**
     * It will fetch the single expense from database
     * @param expenseId
     * @return ExpenseResponse
     * */
    @GetMapping("/expenses/{expenseId}")
    public ExpenseResponse getExpenseById(@PathVariable String expenseId){
        log.info("API GET /expenses/{} called",expenseId);
       ExpenseDTO expenseDTO=expenseService.getExpenseByExpenseId(expenseId);
        log.info("Printing the expense details {}",expenseDTO);
       return mapToExpenseResponse(expenseDTO);
    }

    /**
     * It will delete the expenses from database
     * @return list
     * */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/expenses/{expenseId}")
    public void deleteExpenseByExpenseId(@PathVariable String expenseId){
        log.info("API Delete /expenses/{} called",expenseId);
        expenseService.deleteExpenseByExpenseId(expenseId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/expenses")
    public ExpenseResponse saveExpenseDetails(@Valid @RequestBody ExpenseRequest expenseRequest){
        log.info("API POST /expenses called{}",expenseRequest);
        ExpenseDTO expenseDTO=mapToExpenseDTO(expenseRequest);
        expenseDTO=expenseService.saveExpenseDetails(expenseDTO);
        return mapToExpenseResponse(expenseDTO);
    }

    private ExpenseDTO mapToExpenseDTO(@Valid ExpenseRequest expenseRequest) {
        return modelMapper.map(expenseRequest,ExpenseDTO.class);
    }


    /**
     * Mapper method for converting dto object to expense response
     * @param expenseDTO
     * @return void
     * */
    public ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO){
       return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}
