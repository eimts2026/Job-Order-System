package com.example.jobordersystemeimts.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.*;

@Entity
public class Admin {
    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    // Constructors
    public Admin() {super();}

    public Admin(String fsName, String lsName) {
        this.firstName = fsName;
        this.lastName = lsName;
    }

    public Admin(String fsName, String lsName, String email) {
        this.firstName = fsName;
        this.lastName = lsName;
        this.email = email;
    }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setFirstName(String fsName) { this.firstName = fsName; }
    public void setLastName(String lsName) { this.lastName = lsName; }
    public void setUsername(String usrname) { this.username = usrname; }
    public void setPassword(String pswd) { this.password = pswd; }
    public void setEmail(String email) { this.email = email; }

    // Getters
    public Long getId() { return this.id; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public String getEmail() { return this.email; }

}
