package com.example.exception;

public enum ErrorCodes implements Error {
    SEATS_CAPACITY_EXCEEDED("SEATS_CAPACITY_EXCEEDED", "Seats capacity exceeded", 400),
    INSUFFICIENT_BALANCE("INSUFFICIENT_BALANCE", "Insufficient balance", 400);

    private final String code;
    private final String description;
    private final int httpStatus;

    ErrorCodes(String code, String description, int httpStatus) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getErrorCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getHTTPStatus() {
        return httpStatus;
    }
}