package com.example.InternshipPasteBin.services.usertopastesheet.transformer;


import com.example.InternshipPasteBin.models.UserToPastesheet;
import com.example.InternshipPasteBin.repositories.PasteSheetRepository;
import com.example.InternshipPasteBin.repositories.PermissionRepository;
import com.example.InternshipPasteBin.repositories.UserRepository;
import com.example.InternshipPasteBin.repositories.UserToPastesheetRepository;
import com.example.InternshipPasteBin.services.usertopastesheet.data.UserToPastesheetParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserToPastesheetParamTransformer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasteSheetRepository pasteSheetRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    public UserToPastesheet transform(UserToPastesheetParam param){
        UserToPastesheet userToPastesheet=new UserToPastesheet();
        userToPastesheet.setUser(userRepository.getById(param.getUserId()));
        userToPastesheet.setPasteSheet(pasteSheetRepository.getById(param.getPasteSheetId()));
        userToPastesheet.setPermission(permissionRepository.getById(param.getPermissionId()));
        return userToPastesheet;
    }
}
