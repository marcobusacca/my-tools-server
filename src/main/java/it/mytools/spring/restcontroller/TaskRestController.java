package it.mytools.spring.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mytools.spring.db.pojo.Task;
import it.mytools.spring.db.serv.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {

        List<Task> tasks = taskService.findAll();

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/done/{id}")
    public ResponseEntity<String> setTaskDone(@PathVariable int id) {

        Task task = taskService.findById(id);

        task.setDone(!task.isDone());

        taskService.save(task);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
