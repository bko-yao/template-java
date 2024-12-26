package com.start.templatejava.exception;

/**
 * Exception pour l'entité Categorie
 */
public class CategorieException extends RuntimeException {

    private int errorCode;

    public CategorieException(String message, int errorCode) {
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
