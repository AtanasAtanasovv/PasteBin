package com.example.InternshipPasteBin.controllers;

import com.example.InternshipPasteBin.models.PasteSheet;
import com.example.InternshipPasteBin.services.pastesheet.data.PasteSheetParam;
import com.example.InternshipPasteBin.services.pastesheet.processor.PasteSheetProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pastesheet")
public class PasteSheetsController {
    @Autowired
    private PasteSheetProcessor processor;
    @GetMapping
    public List<PasteSheet> findAll(){
        return processor.findAll();
    }
    @GetMapping("/{id}")
    public PasteSheet getById(@PathVariable Long id){
        return processor.findById(id);
    }
    @PostMapping
    public PasteSheet create(@RequestBody PasteSheetParam param){
        return processor.create(param);
    }
    @PutMapping("/{id}")
    public PasteSheet put(@PathVariable Long id, @RequestBody PasteSheetParam param){
        return processor.put(id,param);
    }
    @DeleteMapping("/id")
    public void delete(@PathVariable Long id){
        processor.delete(id);
    }

}
