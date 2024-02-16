package it.mytools.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.mytools.spring.db.pojo.Task;
import it.mytools.spring.db.serv.TaskService;

@SpringBootApplication
public class MyToolsServerApplication implements CommandLineRunner {

	@Autowired
	private TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(MyToolsServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Task t1 = new Task("task-1");
		// Task t2 = new Task("task-2");
		// taskService.save(t1);
		// taskService.save(t2);
		// System.out.println(t1);
		// System.out.println(t2);
	}

}
