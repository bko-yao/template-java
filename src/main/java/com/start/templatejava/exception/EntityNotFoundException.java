package com.start.templatejava.exception;

/**
 * Exception pour le contrôle des entités
 */
public class EntityNotFoundException extends RuntimeException {

    private int errorCode;

    public EntityNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public EntityNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, Throwable cause, int errorCode) {
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
