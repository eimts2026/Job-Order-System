package com.services;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class Email {
    public static void sendEmail(String to, String subject, String body) {
        // 1. SMTP Server Settings
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        //2. Credentials
        final String username = "joellawrence742005@gmail.com";
        final String password = "odyl brde bgsk ykfo";

        // 3. Create Session
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // 4. Compose Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // 5. Send Email
            Transport.send(message);

            System.out.println("\nEmail sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
