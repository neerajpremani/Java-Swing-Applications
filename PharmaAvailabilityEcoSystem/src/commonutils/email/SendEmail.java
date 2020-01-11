/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils.email;

/**
 *
 * @author Admin
 */
import business.role.Role;
import business.workqueue.WorkRequest;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SendEmail {

    private static final Logger log = LogManager.getLogger(SendEmail.class);

    public void sendMail(String username, String to, String userPassword, Role role) {
        log.info("Mail triggered! to: " + to);
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        final String from = "noreply.optimizeprime.pass@gmail.com";
        final String password = "optimizeprime";
        String sub = "Welcome to Pharma Alliance!";
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            StringBuilder emailBody = new StringBuilder();

           emailBody.append("<h1>Welcome onboard!!!!</h1><br>").
                    append("Your role is: ").
                    append(role).
                    append("</p><p>Your username is :").
                    append(username).
                    append("</p>").
                    append("</p><p>Your Password is: ").
                    append(userPassword).
                    append("</p>");
            message.setContent(emailBody.toString(), "text/html; charset=utf-8");
            //send message
            //send message
            Transport.send(message);
            log.info("Message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public void sendMailMulti(WorkRequest workRequest, List<String> emailIdList) {
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        final String from = "noreply.optimizeprime.pass@gmail.com";
        final String password = "optimizeprime";
        String sub = "Welcome to Pharma Alliance!";
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);

            for (String email : emailIdList) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            }

            message.setSubject(sub);
            message.setContent(createEmailMessageWorkAlert(workRequest), "text/html; charset=utf-8");
            //send message
            Transport.send(message);
            log.info("Message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public String createEmailMessageLoginCredentials(String username, String password) {
        StringBuilder emailBody = new StringBuilder();

        emailBody.append("<h1>Welcome onboard!!!!</h1><br>Your username is :").
                append(username).
                append("</p><p>Your Password is: ").
                append(password).
                append("</p>");

        return emailBody.toString();
    }

    public String createEmailMessageWorkAlert(WorkRequest workRequest) {
        StringBuilder emailBody = new StringBuilder();

        emailBody.append("<h1>Work Request completed successfully</h1><br> Details: Request </p><p>ID: ").
                append(workRequest.getRequestId()).
                append("</p>");

        return emailBody.toString();
    }
}
