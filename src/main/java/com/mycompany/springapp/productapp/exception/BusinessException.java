package com.mycompany.springapp.productapp.exception;

public class BusinessException extends Exception {
    private final String errorMessage;
    private final String errorCode;

    public BusinessException(String errorMessage, String errorCode){
        super();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
