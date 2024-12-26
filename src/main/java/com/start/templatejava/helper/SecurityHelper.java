package com.start.templatejava.helper;

import com.start.templatejava.security.services.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class SecurityHelper {
    /**
     * Recupère l'utilisateur connecté
     *
     * @return
     */
    public static UserDetailsImpl getPrincipal() {
        UserDetailsImpl userDetails = null;
        Object objPrincipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (objPrincipal != null) {
            userDetails = (UserDetailsImpl) objPrincipal;
        }

        return userDetails;
    }

    public static String getBearerToken(HttpServletRequest request) {
        String bearerToken = null;
        String authorization = request.getHeader(AUTHORIZATION);
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
            bearerToken = authorization.substring(7);
        }
        return bearerToken;
    }
}
