package com.pet.adoption.util;

public class ValidationException extends Exception {
    public String toString() {
        return "Validation failed: Invalid or missing input";
    }
}
