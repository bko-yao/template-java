package com.start.templatejava.enumeration;

/**
 * Enumaration pour les codes des erreurs.
 */
public enum ErrorCode {
    ENTITY_NOT_FOUND(1000),
    EMAIL_ALREADY_EXISTS(1001),
    PHONE_NUMBER_ALREADY_EXISTS(1002),

    //
    DATE_MAL_FORME(2000),
    JOUR_INCOHERENT(2001),
    MOIS_INCOHERENT(2002),
    ANNEE_INCOHERENT(2003);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
