package it.mytools.spring.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mytools.spring.db.pojo.TaskCategory;
import it.mytools.spring.db.serv.TaskCategoryService;

@RestController
@RequestMapping("/api/tasks/categories")
public class TaskCategoryRestController {

    @Autowired
    private TaskCategoryService taskCategoryService;

    public ResponseEntity<List<TaskCategory>> getTasksCategories() {

        List<TaskCategory> tasksCategories = taskCategoryService.findAll();

        return new ResponseEntity<>(tasksCategories, HttpStatus.OK);
    }
}
