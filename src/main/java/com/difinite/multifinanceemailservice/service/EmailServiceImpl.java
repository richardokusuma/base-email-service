package com.difinite.multifinanceemailservice.service;

import com.difinite.multifinanceemailservice.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(Email email) throws MessagingException {
        MimeMessage mailMessage = emailSender.createMimeMessage();
//        mailMessage.setS
//
//        SimpleMailMessage message = new SimpleMailMessage();
        mailMessage.setSubject(email.getSubject());
        mailMessage.setRecipients(Message.RecipientType.TO, email.getTo());
//        String htmlMessage = "<div style=\"background-color: lightgrey\">\n" +
//                "        <div style=\"background-color: darkslateblue; color: white; padding: 20px\">\n" +
//                "            <h1>Articlizr</h1>\n" +
//                "            <h3>Forgot Your Password</h3>\n" +
//                "        </div><br>\n" +
//                "        <div style=\"color: black; padding: 20px; \">\n" +
//                "            For reset your password got link below. Dont forget not to show or telling somebody about this page for security reasons.\n" +
//                "            <br><br>\n" +
//                "            <a style=\"text-decoration: none; background-color: dimgrey; border-radius: 2px;\n" +
//                "            color: white; margin: 80px 0px; padding: 12px; max-width: 120px; text-align: center\"\n" +
//                "               href=\"http://localhost:3000/forgot/password/\">Reset Password</a>\n" +
//                "            <br>\n" +
//                "        </div>\n" +
//                "    </div>";
        mailMessage.setContent(email.getBody(), "text/html");
        emailSender.send(mailMessage);
    }

    @Primary
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("richardokusumasali@gmail.com");
        mailSender.setPassword("gcjfpdyqjivtwhud");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
