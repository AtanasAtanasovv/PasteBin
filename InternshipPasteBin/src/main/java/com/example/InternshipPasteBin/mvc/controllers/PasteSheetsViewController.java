package com.example.InternshipPasteBin.mvc.controllers;

import com.example.InternshipPasteBin.models.PasteSheet;
import com.example.InternshipPasteBin.mvc.security.CustomUserDetails;
import com.example.InternshipPasteBin.repositories.PasteSheetRepository;
import com.example.InternshipPasteBin.services.pastesheet.data.PasteSheetParam;
import com.example.InternshipPasteBin.services.pastesheet.processor.PasteSheetProcessor;
import com.example.InternshipPasteBin.services.pastesheet.transformer.PasteSheetParamTransformer;
import com.example.InternshipPasteBin.services.usertopastesheet.data.UserToPastesheetParam;
import com.example.InternshipPasteBin.services.usertopastesheet.processor.UserToPastesheetProcessor;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PasteSheetsViewController {
    @Autowired
    PasteSheetProcessor pasteSheetProcessor;
    @Autowired
    private PasteSheetParamTransformer pasteSheetParamTransformer;
    @Autowired
    UserToPastesheetProcessor userToPastesheetProcessor;
    @GetMapping("/pastesheet")
    public String getPastesheetForm(Model model){
        model.addAttribute("pastesheet",new PasteSheetParam());
        return "pastesheet_form";
    }
    @GetMapping("/pastesheet/{id}")
    public String readPasteSheet(@PathVariable Long id,Model model){
         PasteSheet pastesheet=pasteSheetProcessor.findById(id);
        model.addAttribute("pastesheet",pastesheet);
        if (userToPastesheetProcessor.validateRead(id,getLoggedUserId())){
            return "pastesheet_read";
        } else{
            return "index";
        }
    }

    @PostMapping("/create_pastesheet")
    public String createPastesheet(PasteSheetParam pastesheet){
        pastesheet.setUserId(getLoggedUserId());
        PasteSheet newPastesheet=pasteSheetProcessor.create(pastesheet);
        UserToPastesheetParam userToPastesheetParam=new UserToPastesheetParam();
        userToPastesheetParam.setUserId(getLoggedUserId());
        userToPastesheetParam.setPasteSheetId(newPastesheet.getId());
        userToPastesheetParam.setPermissionId(Long.valueOf(2));
        userToPastesheetProcessor.create(userToPastesheetParam);

        return "users";
    }
    @GetMapping("/pastesheet/edit/{id}")
    public String getEditPastesheet(@PathVariable Long id,Model model){
        PasteSheet pastesheet=pasteSheetProcessor.findById(id);
        PasteSheetParam param=new PasteSheetParam();
        param.setId(pastesheet.getId());
        param.setUserId(pastesheet.getUser().getId());
        param.setTitle(pastesheet.getTitle());
        param.setContent(pastesheet.getContent());
        model.addAttribute("param",param);
        return "pastesheet_edit_own";
    }
    @PostMapping("/pastesheet/edit/{id}")
    public String editPastesheet(@PathVariable Long id,PasteSheetParam param){
        pasteSheetProcessor.put(id,param);
        return "index";
    }

    public Long getLoggedUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = ((CustomUserDetails) principal).getId();
        return id;
    }
}
