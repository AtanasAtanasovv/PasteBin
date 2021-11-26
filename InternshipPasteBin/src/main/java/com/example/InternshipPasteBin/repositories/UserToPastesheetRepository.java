package com.example.InternshipPasteBin.repositories;

import com.example.InternshipPasteBin.models.UserToPastesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserToPastesheetRepository extends JpaRepository<UserToPastesheet,Long> {
    @Query("SELECT utp FROM UserToPastesheet utp " +
            "where utp.permission.id>=1 " +
            "and utp.user.id=?1 " +
            "and utp.pasteSheet.id=?2"
    )
    UserToPastesheet getReadValidation(Long userId,Long pastesheetId);


}
