package com.example.InternshipPasteBin.services.pastesheet.transformer;

import com.example.InternshipPasteBin.models.PasteSheet;
import com.example.InternshipPasteBin.repositories.PasteSheetRepository;
import com.example.InternshipPasteBin.repositories.UserRepository;
import com.example.InternshipPasteBin.services.pastesheet.data.PasteSheetParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PasteSheetParamTransformer {
    @Autowired
    private UserRepository repository;
    public PasteSheet transform(PasteSheetParam param){
        PasteSheet pasteSheet=new PasteSheet();
        pasteSheet.setContent(param.getContent());
        pasteSheet.setTitle(param.getTitle());
        pasteSheet.setUser(repository.findById(param.getUserId()).get());
        return pasteSheet;
    }
}
