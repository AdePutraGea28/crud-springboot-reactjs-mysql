package com.gea.simplecrud.service;

import com.gea.simplecrud.model.entity.User;
import com.gea.simplecrud.model.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Data
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get all
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    // create one
    public User save(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
//        User user1 = userRepository.findById(id).get();
        user.setId(id);

        return userRepository.save(user);
    }

    public String destroyUser(Long id) {
//        User userExists = userRepository.findById(id).get();

        userRepository.deleteById(id);
        return "Success";
    }
}
