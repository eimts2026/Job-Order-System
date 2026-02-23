package com.example.jobordersystemeimts.model;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    private String clientId;

    private String clientName;
}
