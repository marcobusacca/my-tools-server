package it.mytools.spring.auth.db.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mytools.spring.auth.db.pojo.Role;
import it.mytools.spring.auth.db.repo.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {

        return roleRepository.findAll();
    }

    public Role findById(int id) {

        return roleRepository.findById(id).get();
    }

    public void save(Role role) {

        if (role == null) {
            return;
        }

        roleRepository.save(role);
    }

    public void delete(Role role) {

        if (role == null) {
            return;
        }

        roleRepository.delete(role);
    }
}
