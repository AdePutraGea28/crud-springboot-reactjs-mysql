package com.gea.simplecrud.controller;

import com.gea.simplecrud.model.entity.User;
import com.gea.simplecrud.service.UserService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080"})
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create new
    @PostMapping("/users")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    // get all
    @GetMapping("/users")
    public List<User> getAllUser () {
        return userService.getAllUser();
    }

    // get by id
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // update by id
    @PatchMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public String destroyUser(@PathVariable Long id) {
        return userService.destroyUser(id);
    }
}
