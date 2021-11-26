package com.example.InternshipPasteBin.services.usertopastesheet.data;

import lombok.Data;

@Data
public class UserToPastesheetParam {
    private Long id;
    private Long userId;
    private Long pasteSheetId;
    private Long permissionId;
}
