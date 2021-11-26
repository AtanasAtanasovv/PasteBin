package com.example.InternshipPasteBin.controllers;

import com.example.InternshipPasteBin.models.UserToPastesheet;
import com.example.InternshipPasteBin.services.usertopastesheet.data.UserToPastesheetParam;
import com.example.InternshipPasteBin.services.usertopastesheet.processor.UserToPastesheetProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usertopastesheet")
public class UsersToPasteSheetsController {
    @Autowired
    private UserToPastesheetProcessor processor;
    @GetMapping
    public List<UserToPastesheet> findAll(){
        return processor.findAll();
    }
    @GetMapping("/{id}")
    public UserToPastesheet findById(@PathVariable Long id){
        return processor.findById(id);
    }
    @PostMapping
    public UserToPastesheet create(@RequestBody UserToPastesheetParam param){
        return processor.create(param);
    }
    @PutMapping("/{id}")
    public UserToPastesheet put(@PathVariable Long id,@RequestBody UserToPastesheetParam param){
        return processor.put(id,param);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        processor.delete(id);
    }
}
