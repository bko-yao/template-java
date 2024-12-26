package com.start.templatejava.helper;

import com.start.templatejava.dto.auth.ServiceAccountDTO;
import com.start.templatejava.exception.ServiceAccountException;
import com.start.templatejava.repository.ServiceAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.start.templatejava.enumeration.ErrorCode.EMAIL_ALREADY_EXISTS;
import static com.start.templatejava.enumeration.ErrorCode.PHONE_NUMBER_ALREADY_EXISTS;

/**
 * Helper pour les comptes de services.
 */
@Service
@AllArgsConstructor
public class ServiceAccountHelper {
    private final ServiceAccountRepository serviceAccountRepository;

    /**
     * Contrôle si le numéro de téléphone ou l'adresse sont déjà utilisés.
     *
     * @param serviceAccountDTO Service Account
     */
    public void verifyIfEmailOrPhoneNumberExist(ServiceAccountDTO serviceAccountDTO) {
        if (serviceAccountRepository.existsByEmail(serviceAccountDTO.getEmail().toLowerCase().trim())) {
            throw new ServiceAccountException("Email " + serviceAccountDTO.getEmail() + " is already in use!", EMAIL_ALREADY_EXISTS.getCode());
        }
        if (serviceAccountRepository.existsByPhoneNumber(serviceAccountDTO.getPhoneNumber().toLowerCase().trim())) {
            throw new ServiceAccountException("Phone number " + serviceAccountDTO.getPhoneNumber() + " is already in use!", PHONE_NUMBER_ALREADY_EXISTS.getCode());
        }
    }
}
