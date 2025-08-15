package com.trieasenew.tripeasenew.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String str) {
        super(str);
    }
}
