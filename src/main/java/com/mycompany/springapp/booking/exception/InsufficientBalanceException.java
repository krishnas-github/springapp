package com.mycompany.springapp.booking.exception;

public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException(String errMsg){
        super(errMsg);
    }
}
