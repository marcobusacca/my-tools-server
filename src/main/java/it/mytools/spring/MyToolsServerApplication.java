package it.mytools.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.mytools.spring.db.pojo.Task;

@SpringBootApplication
public class MyToolsServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyToolsServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Task t1 = new Task("task-1");

		System.out.println(t1);
	}

}
