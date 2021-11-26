package com.example.InternshipPasteBin.services.pastesheet.processor;

import com.example.InternshipPasteBin.models.PasteSheet;
import com.example.InternshipPasteBin.repositories.PasteSheetRepository;
import com.example.InternshipPasteBin.services.pastesheet.data.PasteSheetParam;
import com.example.InternshipPasteBin.services.pastesheet.transformer.PasteSheetParamTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PasteSheetProcessor {
    @Autowired
    private PasteSheetParamTransformer transformer;
    @Autowired
    private PasteSheetRepository repository;
    public List<PasteSheet> findAll(){
        return repository.findAll();
    }
    public PasteSheet findById(Long id){
        return repository.getById(id);
    }
    public PasteSheet create(PasteSheetParam param){
        PasteSheet sheet=transformer.transform(param);
        return repository.saveAndFlush(sheet);
    }
    public PasteSheet put(Long id, PasteSheetParam param){
        PasteSheet sheet=repository.getById(id);
        sheet.setTitle(param.getTitle());
        sheet.setContent(param.getContent());
        return repository.saveAndFlush(sheet);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}
