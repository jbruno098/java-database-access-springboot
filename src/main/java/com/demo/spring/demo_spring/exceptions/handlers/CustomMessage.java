package com.demo.spring.demo_spring.exceptions.handlers;

public class CustomMessage {

    private String fieldMessage;
    private String message;

    public CustomMessage(String fieldMessage, String message) {
        this.fieldMessage = fieldMessage;
        this.message = message;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public String getMessage() {
        return message;
    }
}
