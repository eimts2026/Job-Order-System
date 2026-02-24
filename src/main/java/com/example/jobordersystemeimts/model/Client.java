package com.example.jobordersystemeimts.model;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    private String clientId;

    private String clientName;
    private String clientPhoneNumber;
    private String clientEmail;
    private String clientWebsite;

    // Constructors
    public Client() { super(); }

    public Client(String name, String phNum, String email) {
        this.clientName = name;
        this.clientPhoneNumber = phNum;
        this.clientEmail = email;
    }

    // Setters
    public void setClientName(String name) { this.clientName = name; }
    public void setClientPhoneNumber(String phNum) { this.clientPhoneNumber  = phNum; }
    public void seClientEmail(String email) { this.clientEmail = email; }
    public void setClientId(String id) { this.clientId = id; }
    public void setClientWebsite(String web) { this.clientWebsite = web;}

    // Getters
    public String getClientName() { return this.clientName; }
    public String getClientPhoneNumer() { return this.clientPhoneNumber; }
    public String getClientEmail() { return this.clientEmail; }
    public String getClientId() { return this.clientId; }
    public String getClientWebsite() { return this.clientWebsite; }

}
