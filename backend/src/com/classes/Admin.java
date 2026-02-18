package com.classes;

import java.util.*;

public class Admin {
    private String firstName;
    private String lastName;
    private String email;
    private static String empID;

    public Admin() {super();}

    public Admin(String firstName, String lastName, String email, String empID) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setEmpID(empID);
    }

    // Setters
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmail(String email) {
        List<String> keywords = List.of("@"); // use Arrays.asList() for multiple criteria
        if (keywords.stream().anyMatch(email::contains)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }
    public void setEmpID(String empID) {this.empID = empID;}

    // Getters
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getFullName() {return this.firstName + " " + this.lastName;}
    public String getEmail() {return this.email;}
    public static String getEmpID() {return empID;}

    // Methods
    @Override
    public String toString() {
        return "Full Name: " + getFullName() + ", Email: " + getEmail() + ", ID: " + getEmpID();
    }
}
