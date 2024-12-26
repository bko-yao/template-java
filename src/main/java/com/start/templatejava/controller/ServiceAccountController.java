package com.start.templatejava.controller;

import com.start.templatejava.dto.auth.ServiceAccountDTO;
import com.start.templatejava.service.ServiceAccountService;
import com.start.templatejava.util.EndpointConstants;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller des comptes de services.
 */
@AllArgsConstructor
@RestController
@RequestMapping(EndpointConstants.SERVICE_ACCOUNT_ENDPOINT)
public class ServiceAccountController {
    private final ServiceAccountService serviceAccountService;

    /**
     * Crée un nouveau compte de service
     *
     * @param serviceAccountDTO Le DTO du compte de service.
     * @return Le statut de la requête.
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createServiceAccount(@Valid @RequestBody ServiceAccountDTO serviceAccountDTO) {
        return ResponseEntity.ok(serviceAccountService.creerServiceAccount(serviceAccountDTO));
    }

    /**
     * Désactive les services account
     *
     * @param ids Les ids des servicesa accounts;
     * @return nothing
     */
    @PreAuthorize("hasRole('EMPLOYEE') " +
            "or hasRole('ADMIN')")
    @PostMapping(value = "/desactive-compte", produces = MediaType.APPLICATION_JSON_VALUE)
    public void desactiveServiceAccount(long[] ids) {
        serviceAccountService.desactiveServiceAccount(ids);
    }
}
