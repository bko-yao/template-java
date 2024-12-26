package com.start.templatejava.util;

import com.start.templatejava.exception.DateException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.time.LocalDate.of;
import static java.util.Objects.nonNull;

public class GeneralUtils {

    @Value("${temporary.token.time}")
    public static long TEMPORARY_TOKEN_TIME;

    /**
     * Récupère l'url dans le context
     *
     * @param request la requête
     * @return l'url.
     */
    public static String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    public static String localDateToString(LocalDate date) {
        if (nonNull(date)) {
            return StringUtils.join(List.of(date.getDayOfMonth(), date.getMonthValue() < 10 ? "0" + date.getMonthValue() : date.getMonthValue(), date.getYear()), "-");
        }
        return "";
    }

    public static String localDateTimeToString(LocalDateTime date) {
        if (nonNull(date)) {
            return StringUtils.join(List.of(date.getDayOfMonth(), date.getMonthValue() < 10 ? "0" + date.getMonthValue() : date.getMonthValue(), date.getYear()), "-");
        }
        return "";
    }

    /**
     * Récupère la différence de temps en (année, jours, heures, minutes, secondes) entre deux dates.
     *
     * @param dateDebut La date de début
     * @param dateFin   La date de fin
     * @return Le temps en annee, jours, heures, minutes, secondes.
     */
    public static String getDifferenceDeTempsEntreDeuxDates(String dateDebut, String dateFin) {
        if (dateDebut != null && dateFin != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            try {
                Date debut = sdf.parse(dateDebut);
                Date fin = sdf.parse(dateFin);

                // Calcule la différence de temps en milliseconds
                long differenceDeTemps = fin.getTime() - debut.getTime();

                // Calcule la différence de temps en
                // seconds, minutes, heures, years,
                // and days
                Long differenceDeSeconds = (differenceDeTemps / 1000) % 60;

                Long differenceDeMinutes = (differenceDeTemps / (1000 * 60)) % 60;

                Long differenceHeures = (differenceDeTemps / (1000 * 60 * 60)) % 24;

                Long differenceAnnee = (differenceDeTemps / (1000L * 60 * 60 * 24 * 365));

                Long differenceEnJours = (differenceDeTemps / (1000 * 60 * 60 * 24)) % 365;

                return StringUtils.join(List.of(differenceAnnee + "a",
                        differenceEnJours + "j",
                        differenceHeures + "h",
                        differenceDeMinutes + "m",
                        differenceDeSeconds + "s"), ":");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return "";
    }

    public static LocalDate stringToLocalDate(String date) {
        String[] split = date.split("-");
        if (split.length == 3) {
            if (parseInt(split[0]) < 0 || parseInt(split[0]) > 31) {
                throw DateException.jourIncoherent(split[0]);
            } else if (parseInt(split[1]) < 0 || parseInt(split[1]) > 12) {
                throw DateException.moisIncoherent(split[1]);
            } else if (parseInt(split[2]) < 1000) {
                throw DateException.anneeIncoherent(split[0]);
            }
            return of(parseInt(split[2]), parseInt(split[1]), parseInt(split[0]));
        }
        throw DateException.dateMalformee(date);
    }

    public static String reverseDateString(String date) {
        String[] split = date.split("-");
        if (split.length == 3) {
            if (parseInt(split[0]) < 0 || parseInt(split[0]) > 31) {
                throw DateException.jourIncoherent(split[0]);
            } else if (parseInt(split[1]) < 0 || parseInt(split[1]) > 12) {
                throw DateException.moisIncoherent(split[1]);
            } else if (parseInt(split[2]) < 1000) {
                throw DateException.anneeIncoherent(split[0]);
            }
            return StringUtils.join(List.of(split[2], split[1], split[0]), "-");
        }
        throw DateException.dateMalformee(date);
    }
}

