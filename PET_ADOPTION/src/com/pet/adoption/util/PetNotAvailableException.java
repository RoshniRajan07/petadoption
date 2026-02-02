package com.pet.adoption.util;

public class PetNotAvailableException extends Exception {
    public String toString() {
        return "Pet is not available for adoption";
    }
}
