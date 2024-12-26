package com.start.templatejava.dto.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * DTO des compte de services des utilisateurs connectés.
 */
@Getter
@Setter
@NoArgsConstructor
public class ServiceAccountDTO {
    private long id;
    private String email;
    private String password;
    private String phoneNumber;
    private Set<String> roles;
}
