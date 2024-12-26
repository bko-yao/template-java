package com.start.templatejava.exception;

import static com.start.templatejava.enumeration.ErrorCode.*;
import static java.lang.String.*;

/**
 * Excepiton pour le contrôle des dates.
 */
public class DateException extends RuntimeException {

    private int errorCode;

    /**
     * Constructeur par défaut
     *
     * @param message le message d'erreur
     */
    public DateException(String message) {
        super(message);
    }

    public DateException(Throwable throwable) {
        super(throwable);
    }

    public DateException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public DateException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public DateException(String message, Throwable cause, int errorCode) {
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

    /**
     * Exception levé lorsque la date n'est pas au format dd-mm-yyyy
     *
     * @param date la date
     * @return l'exception
     */
    public static DateException dateMalformee(String date) {
        return new DateException(
                format("La date %s est malformée, format attendu dd-mm-yyyy", date), DATE_MAL_FORME.getCode());
    }

    public static DateException jourIncoherent(String date) {
        return new DateException(format("%s n'est pas un jour valide", date), JOUR_INCOHERENT.getCode());
    }

    public static DateException moisIncoherent(String date) {
        return new DateException(format("%s n'est pas un mois valide", date), MOIS_INCOHERENT.getCode());
    }

    public static DateException anneeIncoherent(String date) {
        return new DateException(format("%s n'est pas une année valide. L'année doit contenir 4 chiffres au moins.", date), ANNEE_INCOHERENT.getCode());
    }
}
