package in.javascriptjedi.restapi.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @GetMapping("/expenses")
    public String getExpenses(){
        return "Reading the expenses from Database";
    }
}
