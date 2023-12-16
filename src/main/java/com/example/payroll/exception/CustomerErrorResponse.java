package com.example.payroll.exception;


import java.util.ArrayList;
import java.util.List;

public class CustomerErrorResponse {
    List<String> errors = new ArrayList<>();

    public CustomerErrorResponse() {
    }

    public CustomerErrorResponse(List<String> errorMessage) {
        errors = errorMessage;
    }

    public List<String> getErrors() {
        return errors;
    }

}
