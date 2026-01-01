package com.ved.email.api;

import com.ved.email.application.EmailApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    private final EmailApplicationService emailService;

    public EmailController(EmailApplicationService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/send", consumes = "multipart/form-data")
    public ResponseEntity<String> sendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String htmlBody,
            @RequestParam(required = false) MultipartFile[] attachments
    ) throws Exception {

        List<File> files = new ArrayList<>();
        if (attachments != null) {
            for (MultipartFile mf : attachments) {
                File file = File.createTempFile("attach-", mf.getOriginalFilename());
                mf.transferTo(file);
                files.add(file);
            }
        }

        emailService.sendHtmlEmail(to, subject, htmlBody, files);
        return ResponseEntity.ok("Email sent successfully");
    }
}
