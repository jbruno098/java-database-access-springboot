package com.demo.spring.demo_spring.exceptions.handlers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    private List<CustomMessage> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<CustomMessage> getErrors() {
        return errors;
    }

    public void addError(String field, String msg) {
        errors.add(new CustomMessage(field, msg));
    }
}
