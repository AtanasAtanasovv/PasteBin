package com.example.InternshipPasteBin.services.pastesheet.data;

import lombok.Data;

@Data
public class PasteSheetParam {
    private Long id;
    private String title;
    private String content;
    private Long userId;
}
