package com.classes;

public class Client {
    public static String clientName;
    public static String clientPhoneNumber;
    public static String clientEmail;
    public static String clientWebsite;

    public Client() {super();}

    public Client(String clientName, String clientPhoneNumber) {
        setClientName(clientName);
        setClientPhoneNumber(clientPhoneNumber);
    }

    public Client(String clientName, String clientPhoneNumber, String clientEmail) {
        setClientName(clientName);
        setClientPhoneNumber(clientPhoneNumber);
        setClientEmail(clientEmail);
    }

    public Client(String clientName, String clientPhoneNumber, String clientEmail, String clientWebsite) {
        setClientName(clientName);
        setClientPhoneNumber(clientPhoneNumber);
        setClientEmail(clientEmail);
        setClientWebsite(clientWebsite);
    }

    // Setters
    public void setClientName(String cn) {this.clientName = cn;}
    public void setClientPhoneNumber(String pn) {this.clientPhoneNumber = pn;}
    public void setClientEmail(String ce) {this.clientEmail = ce;}
    public void setClientWebsite (String web) {this.clientWebsite = web;}

    // Getters
    public String getClientName() {return this.clientName;}
    public String getClientPhoneNumber() {return this.clientPhoneNumber;}
    public String getClientEmail() {return this.clientEmail;}
    public String getClientWebsite() {return this.clientWebsite;}

//    @Override
//    public String toString() {
//        return "Client Name: " + this.clientName + "\n" +
//                "Client Phone Number: " + this.clientPhoneNumber + "\n" +
//                "Client Email: " + this.clientEmail + "\n" +
//                "Client Website: " + this.clientWebsite;
//    }

    static void main() {
        Client client = new Client("James", "808978696", "james");
        System.out.println(client.toString());
    }
}
