package it.mytools.spring.db.repo.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.mytools.spring.db.pojo.todolist.TaskCategory;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Integer> {

}
