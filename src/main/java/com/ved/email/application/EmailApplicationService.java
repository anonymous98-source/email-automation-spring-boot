package com.ved.email.application;

import com.ved.email.domain.EmailMessage;
import com.ved.email.ports.EmailSenderPort;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class EmailApplicationService {

    private final EmailSenderPort emailSender;

    public EmailApplicationService(EmailSenderPort emailSender) {
        this.emailSender = emailSender;
    }

    public void sendHtmlEmail(String to, String subject, String html, List<File> attachments) {
        EmailMessage email = new EmailMessage(to, subject, html, attachments);
        emailSender.send(email);
    }
}
