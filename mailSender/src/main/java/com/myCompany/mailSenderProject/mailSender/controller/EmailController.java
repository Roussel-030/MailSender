package com.myCompany.mailSenderProject.mailSender.controller;

import com.myCompany.mailSenderProject.mailSender.dto.EmailDTO;
import com.myCompany.mailSenderProject.mailSender.service.EmailServiceInterface;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/email")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EmailController {

    @Autowired
    private EmailServiceInterface emailService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailDTO emailDTO) {
        try {
            emailService.sendEmail(emailDTO);
            return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
        } catch (MessagingException e) {
            return new ResponseEntity<>("Failed to send email: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
