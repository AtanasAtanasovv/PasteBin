package com.example.InternshipPasteBin.services.usertopastesheet.processor;

import com.example.InternshipPasteBin.models.PasteSheet;
import com.example.InternshipPasteBin.models.UserToPastesheet;
import com.example.InternshipPasteBin.repositories.PasteSheetRepository;
import com.example.InternshipPasteBin.repositories.PermissionRepository;
import com.example.InternshipPasteBin.repositories.UserRepository;
import com.example.InternshipPasteBin.repositories.UserToPastesheetRepository;
import com.example.InternshipPasteBin.services.pastesheet.data.PasteSheetParam;
import com.example.InternshipPasteBin.services.usertopastesheet.data.UserToPastesheetParam;
import com.example.InternshipPasteBin.services.usertopastesheet.transformer.UserToPastesheetParamTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserToPastesheetProcessor {
    @Autowired
    private UserToPastesheetRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PasteSheetRepository pasteSheetRepository;
    @Autowired
    private UserToPastesheetParamTransformer transformer;

    public List<UserToPastesheet> findAll(){
        return repository.findAll();
    }
    public UserToPastesheet findById(Long id){
        return repository.getById(id);
    }
    public UserToPastesheet create(UserToPastesheetParam param){
        UserToPastesheet userToPastesheet=transformer.transform(param);
        return repository.saveAndFlush(userToPastesheet);
    }
    public UserToPastesheet put(Long id,UserToPastesheetParam param){
        UserToPastesheet userToPastesheet=repository.getById(id);
        userToPastesheet.setUser(userRepository.getById(param.getUserId()));
        userToPastesheet.setPasteSheet(pasteSheetRepository.getById(param.getPasteSheetId()));
        userToPastesheet.setPermission(permissionRepository.getById(param.getPermissionId()));
        return repository.saveAndFlush(userToPastesheet);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
    public boolean validateRead(Long pastesheetId,Long userId){
        return repository.getReadValidation(userId,pastesheetId)!=null;
    }
}
