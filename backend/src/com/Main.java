package com;

import java.util.*;

import com.classes.JobOrder;
import java.util.Map;
import java.util.HashMap;

// main process imports
import com.services.AdminService;
import com.services.DatabaseService;
import com.services.JobOrderService;
import com.services.Email;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, JobOrder> allJobOrders = new HashMap<>();

        // MySQL
        String url = "jdbc:mysql://localhost:3306/my_first_db";
        String user = "root";
        String password = "Zyzz@2022";

        // System.out.println("Connecting...");

        // Main
        boolean flag = false;
        while (!flag) {
            System.out.println("\n\n");
            System.out.println(" --- MAIN --- ");
            System.out.println("What would you like to do?");
            System.out.println("1. Admin");
            System.out.println("2. Job Order");

            System.out.print("\nEnter your choice: ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("1. Create Admin");
                System.out.println("2. View Admins");
                System.out.println("3. Delete Admins");
                System.out.println("4. Update Admins");
                System.out.println("5. Exit");

                System.out.print("\nEnter your choice: ");
                int option = input.nextInt();

                if (option == 1) {
                    AdminService.createAdmin();
                } else if (option == 2) {
                    DatabaseService.loadAdminDatabase();
                    System.out.println("\n --- Admins --- ");
                    for (String s : AdminService.allAdmins.keySet()) {
                        System.out.println(s + " - " + AdminService.allAdmins.get(s).getFullName());
                    }
                } else if (option == 3) {
                    AdminService.deleteAdmin();
                } else if (option == 4) {
                    AdminService.updateAdmin();
                } else if (option == 5) {
                    break;
                }
            } else if (choice == 2) {
                System.out.println("1. Create Job Orders");
                System.out.println("2. View Job Orders");
                System.out.println("3. Delete Job Orders");
                System.out.println("4. Update Job Orders");
                System.out.println("5. Assign Admin");
                System.out.println("6. Exit");

                System.out.print("\nEnter your choice: ");
                int option = input.nextInt();

                if (option == 1) {
                    JobOrderService.createJobOrder();
                } else if (option == 2) {
                    DatabaseService.loadJobOrderDatabase();
                    System.out.println("\n --- Job Orders --- ");
                    for (String s : JobOrderService.allJobOrders.keySet()) {
                        System.out.println(s + " - " + JobOrderService.allJobOrders.get(s).getJobName());
                    }
                } else if (option == 3) {
                    //
                } else if (option == 4) {
                    JobOrderService.updateJobOrder();
                } else if (option == 5) {
                    //
                } else if (option == 6) {
                    break;
                }
            }

        }

    }
}
