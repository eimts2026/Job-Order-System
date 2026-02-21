package main.com.joborder.system.service;

import java.util.Map;
import java.util.HashMap;
import java.util.*;

import main.com.joborder.system.model.JobOrder;
import com.tokens.Token;
import main.com.joborder.system.service.Email;

public class JobOrderService {
    public static Map<String, JobOrder> allJobOrders = new HashMap<>();
    public static Scanner input = new Scanner(System.in);

    public static void createJobOrder() {
        boolean flag = false;
        System.out.print("Enter Job Order Name: ");
        String jobOrderName = input.nextLine();

        System.out.print("Enter Job Order Description: ");
        String jobOrderDes = input.nextLine();

        JobOrder newJobOrder = new JobOrder();

        while (!flag) {
            String token = Token.getToken();
            System.out.print("Job Order ID: " + token);
            newJobOrder = new JobOrder(jobOrderName, jobOrderDes, token);

            DatabaseService.loadAdminDatabase();

            if (AdminService.allAdmins.containsKey(newJobOrder.getJobOrderID())) {
                System.out.println("Order ID Already Exists: ");
                System.out.println(AdminService.allAdmins.get(newJobOrder.getJobOrderID()));
            } else {
                flag = true;
            }
        }

        allJobOrders.put(newJobOrder.getJobOrderID(), newJobOrder);
        DatabaseService.insertJobOrder(newJobOrder);
        System.out.println("Job Order Successfully Created!");

        //Email.sendEmail();

    }

    public static void updateJobOrder() {
        DatabaseService.loadJobOrderDatabase();

        for (String s : allJobOrders.keySet()) {
            System.out.println(s + " - " + allJobOrders.get(s).getJobOrderID());
        }

        System.out.print("\nEnter Job Order ID: ");
        String oldID = input.nextLine();

        int check = DatabaseService.checkJobOrderDatabase();

        if (allJobOrders.containsKey(oldID) && (check == 1)) {

            System.out.println(allJobOrders.get(oldID).toString());

            System.out.println("\n");
            System.out.println("-- UPDATE JOB ORDERS --");

            System.out.print("Enter Job Order Name: ");
            String newJobOrderName = input.nextLine();
            System.out.println("Enter Job Order Description: ");
            String newJobOrderDes = input.nextLine();
            System.out.print("Enter Job Order ID: ");
            String newJobOrderID = input.nextLine();

            JobOrder newJobOrder = new JobOrder(newJobOrderName, newJobOrderDes, newJobOrderID);

            allJobOrders.put(oldID, newJobOrder);
            DatabaseService.updateJobOrder(newJobOrder, oldID);

            System.out.println("\nAdmin Updated Successfully!");
        }
    }

    public static void assignAdmin() {
        //
    }


}