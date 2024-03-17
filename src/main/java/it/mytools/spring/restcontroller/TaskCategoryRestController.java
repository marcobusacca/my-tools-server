package it.mytools.spring.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mytools.spring.db.pojo.TaskCategory;
import it.mytools.spring.db.serv.TaskCategoryService;
import it.mytools.spring.db.pojo.Task;
import it.mytools.spring.db.serv.TaskService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/tasks/categories")
public class TaskCategoryRestController {

    @Autowired
    private TaskCategoryService taskCategoryService;
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskCategory>> getTasksCategories() {

        List<TaskCategory> tasksCategories = taskCategoryService.findAll();

        return new ResponseEntity<>(tasksCategories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> storeTaskCategory(@RequestBody TaskCategory taskCategoryForm) {

        TaskCategory taskCategory = new TaskCategory(taskCategoryForm.getTitle());

        taskCategoryService.save(taskCategory);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateTaskCategory(@PathVariable int id, @RequestBody TaskCategory taskCategoryForm) {

        TaskCategory taskCategory = taskCategoryService.findById(id);

        taskCategory.setTitle(taskCategoryForm.getTitle());

        taskCategoryService.save(taskCategory);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTaskCategory(@PathVariable int id) {

        TaskCategory taskCategory = taskCategoryService.findById(id);
        int taskCategoryId = taskCategory.getId();

        List<Task> tasksToDelete = taskService.findByTaskCategoryId(taskCategoryId);
        for (Task task : tasksToDelete) {
            taskService.delete(task);
        }

        taskCategoryService.delete(taskCategory);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
