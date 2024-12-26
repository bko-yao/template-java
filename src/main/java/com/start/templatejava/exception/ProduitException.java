package com.start.templatejava.exception;

/**
 * Exception pour l'entité Product.
 */
public class ProduitException extends RuntimeException {

    private int errorCode;

    public ProduitException(String message, int errorCode) {
        super(message);
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
