package it.mytools.spring.restcontroller.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mytools.spring.db.serv.tracker.ExpenseService;

@RestController
@RequestMapping("/api/tracker/expenses")
public class ExpenseRestController {

    @Autowired
    private ExpenseService expenseService;
}
