package com.rest.webservices.controller;

import com.rest.webservices.entities.User;
import com.rest.webservices.exception.UserNotFoundException;
import com.rest.webservices.services.UserDaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
        User user =  userDaoServices.findOne(id);

        if(user==null)
            throw new UserNotFoundException("id-"+ id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUsers(@Valid @RequestBody User user)
    {
        User savedUser = userDaoServices.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        User user =  userDaoServices.deleteById(id);

        if(user==null)
            throw new UserNotFoundException("id-"+ id);
    }
}
