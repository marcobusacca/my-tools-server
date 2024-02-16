package it.mytools.spring.db.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mytools.spring.db.pojo.TaskCategory;
import it.mytools.spring.db.repo.TaskCategoryRepository;

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
        taskCategoryRepository.save(taskCategory);
    }

    public void delete(TaskCategory taskCategory) {
        taskCategoryRepository.delete(taskCategory);
    }
}
