package it.mytools.spring;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.mytools.spring.db.pojo.todolist.Task;
import it.mytools.spring.db.pojo.todolist.TaskCategory;
import it.mytools.spring.db.pojo.tracker.Expense;
import it.mytools.spring.db.pojo.tracker.Wallet;
import it.mytools.spring.db.serv.todolist.TaskCategoryService;
import it.mytools.spring.db.serv.todolist.TaskService;
import it.mytools.spring.db.serv.tracker.ExpenseService;
import it.mytools.spring.db.serv.tracker.WalletService;

@SpringBootApplication
public class MyToolsServerApplication implements CommandLineRunner {

	@Autowired
	private TaskCategoryService taskCategoryService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private WalletService walletService;

	@Autowired
	private ExpenseService expenseService;

	public static void main(String[] args) {
		SpringApplication.run(MyToolsServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		TaskCategory tc1 = new TaskCategory("lavoro");
		TaskCategory tc2 = new TaskCategory("personale");
		taskCategoryService.save(tc1);
		taskCategoryService.save(tc2);

		Task t1 = new Task("task-1", tc1);
		Task t2 = new Task("task-2", tc2);
		taskService.save(t1);
		taskService.save(t2);

		Wallet wallet1 = new Wallet("contanti", 0);
		walletService.save(wallet1);

		Expense expense1 = new Expense(LocalDate.now(), "ho speso troppi soldi", wallet1, 1000);
		expenseService.save(expense1);
	}
}
