package com.example.demo.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleIntegrityViolation(DataIntegrityViolationException ex, Model model) {
        model.addAttribute("error", "Database constraint violation: " + ex.getRootCause().getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleOtherExceptions(Exception ex, Model model) {
        model.addAttribute("error", "Unexpected error: " + ex.getMessage());
        return "error";
    }
}