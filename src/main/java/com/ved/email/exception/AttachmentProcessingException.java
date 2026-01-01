package com.ved.email.exception;

public class AttachmentProcessingException extends RuntimeException {

    public AttachmentProcessingException(String message) {
        super(message);
    }

    public AttachmentProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
