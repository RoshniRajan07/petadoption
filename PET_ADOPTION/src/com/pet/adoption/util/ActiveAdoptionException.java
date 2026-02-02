package com.pet.adoption.util;

public class ActiveAdoptionException extends Exception {
    public String toString() {
        return "Cannot remove pet: Active adoption exists";
    }
}
