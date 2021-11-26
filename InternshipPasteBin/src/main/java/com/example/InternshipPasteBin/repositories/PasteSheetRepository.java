package com.example.InternshipPasteBin.repositories;

import com.example.InternshipPasteBin.models.PasteSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasteSheetRepository extends JpaRepository<PasteSheet,Long> {
}
