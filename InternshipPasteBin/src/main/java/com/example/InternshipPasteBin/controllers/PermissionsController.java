package com.example.InternshipPasteBin.controllers;

import com.example.InternshipPasteBin.models.Permission;
import com.example.InternshipPasteBin.services.permission.PermissionProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permission")
public class PermissionsController {
    @Autowired
    private PermissionProcessor processor;
    @GetMapping
    public List<Permission> findAll(){
        return processor.findAll();
    }
    @GetMapping("/{id}")
    public Permission findById(@PathVariable Long id){
        return processor.findById(id);
    }
    @PostMapping
    public Permission create(@RequestBody Permission permission){
        return processor.create(permission);
    }
    @PutMapping("/{id}")
    public Permission put(@PathVariable Long id,@RequestBody Permission permission){
        return processor.put(id,permission);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        processor.delete(id);
    }
}
