package com.myCompany.mailSenderProject.mailSender.service;

import com.myCompany.mailSenderProject.mailSender.dto.EmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailService implements EmailServiceInterface{

    @Autowired
    private JavaMailSender javaMailSender;

    private void addAttachments(MimeMessageHelper helper, EmailDTO emailDTO) throws MessagingException {
        for (String filePath: emailDTO.attachments()) {
            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment(file.getFilename(), file);
        }
    }

    @Override
    public void sendEmail(EmailDTO emailDTO) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        helper.setTo(emailDTO.to());
        helper.setFrom(emailDTO.from());
        helper.setSubject(emailDTO.subject());
        helper.setText(emailDTO.text());

        if(emailDTO.attachments() != null) {
            addAttachments(helper, emailDTO);
        }

        javaMailSender.send(mimeMessage);
    }

}
