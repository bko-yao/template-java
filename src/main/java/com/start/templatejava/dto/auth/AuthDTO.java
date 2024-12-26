package com.start.templatejava.dto.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO pour l'authentification des utilisateurs.
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthDTO {
    private String email;
    private String password;
}
