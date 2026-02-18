package com.services;

import java.util.Map;
import java.util.HashMap;
import java.util.*;

import com.classes.Admin;

public class AdminService {
    public static Map<String, Admin> allAdmins = new HashMap<>();
    public static Scanner input = new Scanner(System.in);

    public static void createAdmin() {
        /**
         * This method creates an Admin, and adds admin to HashMap and database
         */
        System.out.print("\nEnter Admin First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Admin Last Name: ");
        String lastName = input.nextLine();

        System.out.print("Enter Admin Email: ");
        String email = input.nextLine();

        System.out.print("Enter Admin ID: ");
        String id = input.nextLine();

        Admin newAdmin = new Admin(firstName, lastName, email, id);

        DatabaseService.insertAdmin(newAdmin);
        allAdmins.put(newAdmin.getEmpID(), newAdmin);

        System.out.println("\nAdmin Added Successfully!");
    }

    public static void updateAdmin() {
        for (String s : allAdmins.keySet()) {
            System.out.println(s + " - " + allAdmins.get(s).getFullName());
        }

        System.out.print("\nEnter Admin Employee ID: ");
        String oldID = input.nextLine();

        int check = DatabaseService.checkAdminDatabase();

        if (allAdmins.containsKey(oldID) && (check == 1)) {

            System.out.println(allAdmins.get(oldID).toString());

            System.out.println("\n");
            System.out.println("-- UPDATE ADMIN --");

            System.out.print("Enter Admin First Name: ");
            String newFirstName = input.nextLine();
            System.out.print("Enter Admin Last Name: ");
            String newLastName = input.nextLine();
            System.out.print("Enter Admin Email: ");
            String newEmail = input.nextLine();
            System.out.print("Enter Admin ID: ");
            String newID = input.nextLine();

            Admin newAdmin = new Admin(newFirstName, newLastName, newEmail, newID);

            allAdmins.put(oldID, newAdmin);
            DatabaseService.updateAdmin(newAdmin, oldID);

            System.out.println("\nAdmin Updated Successfully!");
        }

    }

    public static void deleteAdmin() {
        for (String s : allAdmins.keySet()) {
            System.out.println(s);
        }

        System.out.print("\nEnter Admin ID: ");
        String adminID = input.nextLine();

        int check = DatabaseService.checkAdminDatabase();

        if (allAdmins.containsKey(adminID) && (check == 1)) {
            DatabaseService.deleteAdmin(allAdmins.get(adminID));

            allAdmins.remove(adminID);
            System.out.println("\nAdmin Removed Successfully!");
        }
    }
}
