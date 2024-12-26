package com.start.templatejava.security.services;

import com.start.templatejava.entity.ServiceAccount;
import com.start.templatejava.exception.EntityNotFoundException;
import com.start.templatejava.repository.ServiceAccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ServiceAccountRepository serviceAccountRepository;

    public UserDetailsServiceImpl(ServiceAccountRepository serviceAccountRepository) {
        this.serviceAccountRepository = serviceAccountRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws EntityNotFoundException {
        Optional<ServiceAccount> person = serviceAccountRepository.findByEmailAndAssetTrue(username);

        if (person.isEmpty()) {
            throw new EntityNotFoundException("User Not Found with email: " + username);
        }
        return UserDetailsImpl.build(person.get());
    }
}
