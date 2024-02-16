package it.mytools.spring.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.mytools.spring.db.pojo.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
