package com.start.templatejava.exception;

/**
 * Exception pour le contrôle des comptes de services.
 */
public class ServiceAccountException extends RuntimeException {
    private int errorCode;

    public ServiceAccountException(Throwable throwable) {
        super(throwable);
    }

    public ServiceAccountException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public ServiceAccountException(String message) {
        super(message);
    }

    public ServiceAccountException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceAccountException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return this.errorCode + " : " + this.getMessage();
    }
}
