package com.difinite.multifinanceemailservice.service;

import com.difinite.multifinanceemailservice.model.Email;


import javax.mail.MessagingException;

public interface EmailService {
    void sendSimpleMessage(Email email) throws MessagingException;
}
