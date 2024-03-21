package it.mytools.spring.db.serv.tracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mytools.spring.db.pojo.tracker.Expense;
import it.mytools.spring.db.repo.tracker.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense findById(int id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public void save(Expense expense) {
        if (expense == null) {
            return;
        }
        expenseRepository.save(expense);
    }

    public void delete(Expense expense) {
        if (expense == null) {
            return;
        }
        expenseRepository.delete(expense);
    }
}
