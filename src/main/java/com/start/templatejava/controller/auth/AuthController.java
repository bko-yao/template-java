package com.start.templatejava.controller.auth;

import com.start.templatejava.dto.auth.AuthDTO;
import com.start.templatejava.dto.auth.JwtResponseDTO;
import com.start.templatejava.service.implementation.AuthService;
import com.start.templatejava.util.EndpointConstants;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(EndpointConstants.AUTHENTICATION_ENDPOINT + "/signin")
public class AuthController {
    private final AuthService authService;

    /**
     * Authentifie tous les customers
     *
     * @param authDTO Service Account de Customer
     * @return Le token
     */
    @PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public JwtResponseDTO loginCustomer(@Valid @RequestBody AuthDTO authDTO) {
        return authService.login(authDTO);
    }

    /**
     * Authentifie tous les employees
     *
     * @param authDTO Service Account de Customer
     * @return Le token
     */
    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public JwtResponseDTO loginEmployee(@Valid @RequestBody AuthDTO authDTO) {
        return authService.login(authDTO);
    }

    /**
     * Authentifie tous les prestataires (Particulier/Entreprise)
     *
     * @param authDTO Service Account de Customer
     * @return Le token
     */
    @PostMapping(value = "/provider", produces = MediaType.APPLICATION_JSON_VALUE)
    public JwtResponseDTO loginParticularProvider(@Valid @RequestBody AuthDTO authDTO) {
        return authService.login(authDTO);
    }
}
