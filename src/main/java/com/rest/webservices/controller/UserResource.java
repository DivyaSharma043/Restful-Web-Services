package com.rest.webservices.controller;

import com.rest.webservices.entities.User;
import com.rest.webservices.services.UserDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoServices userDaoServices;

    @GetMapping("/users")
    public List<User> retrieveAllUsers()
    {
        return userDaoServices.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id)
    {
        return userDaoServices.findOne(id);
    }

    @PostMapping("/users")
    public void createUsers(@RequestBody User user)
    {
        User savedUser = userDaoServices.save(user);
    }
}
