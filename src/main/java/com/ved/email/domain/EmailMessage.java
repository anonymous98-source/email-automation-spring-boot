package com.ved.email.domain;

import java.io.File;
import java.util.List;

public class EmailMessage {

    private String to;
    private String subject;
    private String htmlBody;
    private List<File> attachments;

    public EmailMessage(String to, String subject, String htmlBody, List<File> attachments) {
        this.to = to;
        this.subject = subject;
        this.htmlBody = htmlBody;
        this.attachments = attachments;
    }

    public String getTo() { return to; }
    public String getSubject() { return subject; }
    public String getHtmlBody() { return htmlBody; }
    public List<File> getAttachments() { return attachments; }
}
