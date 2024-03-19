package it.mytools.spring.auth.db.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.mytools.spring.auth.db.pojo.User;
import it.mytools.spring.auth.db.repo.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User findById(int id) {

        return userRepository.findById(id).get();
    }

    public void save(User user) {

        if (user == null) {
            return;
        }

        userRepository.save(user);
    }

    public void delete(User user) {

        if (user == null) {
            return;
        }

        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("Username not found");

        return user;
    }
}
