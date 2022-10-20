package com.mikemopo.workbook.controller;

import com.mikemopo.workbook.model.User;
import com.mikemopo.workbook.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/save")
    public User addUser(@RequestBody User user){
        return userServiceImpl.saveUser(user);
    }
    @GetMapping("/getAll")
    public List<User> findAllUsers(){
        return userServiceImpl.getUsers();
    }

    @GetMapping("/userById/{id}")
    public User  findUserById(@PathVariable Long id){
        return userServiceImpl.getUserById(id);
    }
    @DeleteMapping("/remove/{id}")
    public  User deleteUser(@PathVariable Long id){
        User user = userServiceImpl.getUserById(id);
       return userServiceImpl.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        User user = userServiceImpl.getUserById(id);
        return userServiceImpl.updateUser(user);
    }

}
