package com.aries.hermes.dal.exception;

public class BatchQueryException extends Exception {
    public BatchQueryException(String message) {
        super(message);
    }

    public BatchQueryException(String message, Throwable e) {
        super(message, e);
    }
}
