package com.example.exception;

public class TravelServiceException extends RuntimeException {
    private final Error error;

    public TravelServiceException(Error error, String message) {
        super(message != null ? message : error.getDescription());
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}

interface Error {
    String getDescription();
    int getHTTPStatus();
    String getErrorCode();
}