package it.mytools.spring.db.serv.todolist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mytools.spring.db.pojo.todolist.TaskCategory;
import it.mytools.spring.db.repo.todolist.TaskCategoryRepository;

@Service
public class TaskCategoryService {

    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    public List<TaskCategory> findAll() {
        return taskCategoryRepository.findAll();
    }

    public TaskCategory findById(int id) {
        return taskCategoryRepository.findById(id).get();
    }

    public void save(TaskCategory taskCategory) {
        if (taskCategory == null) {
            return;
        }
        taskCategoryRepository.save(taskCategory);
    }

    public void delete(TaskCategory taskCategory) {
        if (taskCategory == null) {
            return;
        }
        taskCategoryRepository.delete(taskCategory);
    }
}
