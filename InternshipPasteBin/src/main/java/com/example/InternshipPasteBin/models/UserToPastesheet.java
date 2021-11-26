package com.example.InternshipPasteBin.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "UsersToPastesheets")
public class UserToPastesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "pastesheet_id",nullable = false)
    private PasteSheet pasteSheet;
    @ManyToOne
    @JoinColumn(name = "permission_id",nullable = false)
    private Permission permission;

}
