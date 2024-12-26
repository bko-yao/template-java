package com.start.templatejava.factory;

import com.start.templatejava.dto.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MessageResponseFactory {

    public static ResponseEntity<?> succesServiceAccount() {
        return ResponseEntity.ok()
                .body(MessageResponse.builder()
                        .message("Compte de service enregistré avec succès")
                        .build());
    }

    public static ResponseEntity<?> phoneNumberExist(String phoneNumber) {
        return ResponseEntity.ok()
                .body(MessageResponse.builder()
                        .message("Ce numéro est déjà utilisé souhaitez-vous continuer " +
                                "avec ce numéro ?")
                        .build());
    }
}
