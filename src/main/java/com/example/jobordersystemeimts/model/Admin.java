package com.example.jobordersystemeimts.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.*;

@Entity
public class Admin {
    @Id
    private Long id;
    private String username;
    private String password;
}
