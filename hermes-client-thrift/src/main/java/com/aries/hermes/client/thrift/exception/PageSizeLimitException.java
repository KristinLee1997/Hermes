package com.aries.hermes.client.thrift.exception;

public class PageSizeLimitException extends Exception {
    public PageSizeLimitException() {
    }

    public PageSizeLimitException(String message) {
        super(message);
    }

    public PageSizeLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageSizeLimitException(Throwable cause) {
        super(cause);
    }

    public PageSizeLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
