package com.email.emailapi.service;

import java.util.Properties;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service
public class EmailService {

    public boolean sendEmail(String subject, String message, String to){

        boolean f = false;

//      SET YOUR OWN EMAIL ADDRESS
        String from = "";

        String host ="smtp.gmail.com";

        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

//      SET YOUR EMAIL ADDRESS AND PASSWORD
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", "");
            }
        });

        session.setDebug(true);

        MimeMessage m = new MimeMessage(session);

        try {

            m.setFrom(from);

            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            m.setSubject(subject);

            m.setText(message);

            Transport.send(m);

            System.out.println("Sukces.............");
            f = true;

        } catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
