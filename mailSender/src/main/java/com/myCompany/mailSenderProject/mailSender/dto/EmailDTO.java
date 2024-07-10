package com.myCompany.mailSenderProject.mailSender.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record EmailDTO(String from, String subject, String text, List<MultipartFile> attachments ) {
}
