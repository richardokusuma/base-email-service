package com.difinite.multifinanceemailservice.controller;

import com.difinite.multifinanceemailservice.model.Email;
import com.difinite.multifinanceemailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class EmailController {
    @Autowired
    public EmailService emailService;

    @RequestMapping("/send")
    public String sendMail(@RequestParam("to") String to, @RequestParam("subject") String subject,
                           @RequestParam("body") String body) throws MessagingException {
        Email email = new Email();
        email.setTo(to);
        email.setSubject(subject);
        email.setBody(body);
        emailService.sendSimpleMessage(email);
        return "Message Sended";
    }

    @RequestMapping("/test")
    public String test(@RequestParam("to") String to, @RequestParam("subject") String subject,
                       @RequestParam("body") String body){
        return "test";
    }
}
