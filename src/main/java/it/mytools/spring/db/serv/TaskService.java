package it.mytools.spring.db.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mytools.spring.db.pojo.Task;
import it.mytools.spring.db.repo.TaskRepository;

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

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }
}
