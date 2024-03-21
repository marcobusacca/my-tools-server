package it.mytools.spring.restcontroller.tracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mytools.spring.db.pojo.tracker.Expense;
import it.mytools.spring.db.serv.tracker.ExpenseService;

@RestController
@RequestMapping("/api/tracker/expenses")
public class ExpenseRestController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses() {

        List<Expense> expenses = expenseService.findAll();

        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
}
