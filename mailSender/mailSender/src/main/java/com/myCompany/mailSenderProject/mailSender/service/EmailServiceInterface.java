package com.myCompany.mailSenderProject.mailSender.service;

import com.myCompany.mailSenderProject.mailSender.dto.EmailDTO;
import jakarta.mail.MessagingException;

public interface EmailServiceInterface {
    void sendEmail(EmailDTO emailDTO) throws MessagingException;
}
