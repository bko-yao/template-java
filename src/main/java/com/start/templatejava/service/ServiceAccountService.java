package com.start.templatejava.service;

import com.start.templatejava.dto.auth.ServiceAccountDTO;
import com.start.templatejava.entity.Role;
import com.start.templatejava.entity.ServiceAccount;
import com.start.templatejava.factory.MessageResponseFactory;
import com.start.templatejava.helper.RoleHelper;
import com.start.templatejava.helper.ServiceAccountHelper;
import com.start.templatejava.repository.ServiceAccountRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class ServiceAccountService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder encoder;
    private final ServiceAccountRepository serviceAccountRepository;
    private final RoleHelper roleHelper;
    private final ServiceAccountHelper serviceAccountHelper;

    /**
     * Enregistre un compte de service
     *
     * @param serviceAccountDTO Le compte de service
     */
    public ResponseEntity<?> creerServiceAccount(ServiceAccountDTO serviceAccountDTO) {
        ServiceAccount serviceAccount = modelMapper.map(serviceAccountDTO, ServiceAccount.class);
        this.serviceAccountHelper.verifyIfEmailOrPhoneNumberExist(serviceAccountDTO);

        Set<String> strRoles = serviceAccountDTO.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            roles.add(roleHelper.addRole(role));
        });

        serviceAccount.setRecord(roles, encoder.encode(serviceAccountDTO.getPassword().trim()),
                serviceAccountDTO.getEmail(), serviceAccountDTO.getPhoneNumber());
        serviceAccountRepository.save(serviceAccount);
        return MessageResponseFactory.succesServiceAccount();
    }

    /**
     * Desactive les comptes des services.
     *
     * @param ids Les ids des services account à desactiver.
     */
    public void desactiveServiceAccount(long[] ids) {
        this.serviceAccountRepository.findByIdsAndAsset(ids)
                .forEach(serviceAccount -> serviceAccount.setAsset(false));
    }
}
