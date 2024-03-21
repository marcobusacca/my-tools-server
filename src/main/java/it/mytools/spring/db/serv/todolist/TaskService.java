package it.mytools.spring.db.serv.todolist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mytools.spring.db.pojo.todolist.Task;
import it.mytools.spring.db.repo.todolist.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(int id) {
        return taskRepository.findById(id).get();
    }

    public List<Task> findByTaskCategoryId(int taskCategoryId) {
        return taskRepository.findByTaskCategoryId(taskCategoryId);
    }

    public void save(Task task) {
        if (task == null) {
            return;
        }
        taskRepository.save(task);
    }

    public void delete(Task task) {
        if (task == null) {
            return;
        }
        taskRepository.delete(task);
    }
}
