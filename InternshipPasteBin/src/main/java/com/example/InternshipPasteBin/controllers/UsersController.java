package com.example.InternshipPasteBin.controllers;

import com.example.InternshipPasteBin.models.User;
import com.example.InternshipPasteBin.services.user.UserProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersController {
    @Autowired
    private UserProcessor processor;
    @GetMapping
    public List<User> findAll(){
        return processor.findAll();
    }
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return processor.findById(id);
    }
    @PostMapping
    public User create(@RequestBody User user){
        return processor.create(user);
    }
    @PutMapping("/{id}")
    public User put(@PathVariable Long id,@RequestBody User user){
        return processor.put(id,user);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        processor.delete(id);
    }
}
