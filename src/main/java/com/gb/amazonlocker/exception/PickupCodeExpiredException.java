package com.gb.amazonlocker.exception;

public class PickupCodeExpiredException extends Exception {
    public PickupCodeExpiredException(String message) {
        super(message);
    }
}
