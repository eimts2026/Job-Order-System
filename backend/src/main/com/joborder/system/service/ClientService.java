package main.com.joborder.system.service;

import main.com.joborder.system.model.Client;

import java.util.*;

public class ClientService {
    public static Scanner input = new Scanner(System.in);

    public static void createClient() {
        System.out.print("Client Name: ");
        String name = input.nextLine();

        System.out.println("Client Phone Number: ");
        String phoneNumber = input.nextLine();

        System.out.println("Client Email: ");
        String email = input.nextLine();

        Client newClient = new Client(name, phoneNumber, email);
    }

    public static void addClient() {

    }
}
