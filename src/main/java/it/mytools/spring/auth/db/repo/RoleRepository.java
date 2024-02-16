package it.mytools.spring.auth.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.mytools.spring.auth.db.pojo.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
