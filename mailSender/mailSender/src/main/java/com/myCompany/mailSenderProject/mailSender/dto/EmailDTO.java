package com.myCompany.mailSenderProject.mailSender.dto;

import java.util.List;

public record EmailDTO(String to, String from, String subject, String text, List<String> attachments ) {
}
