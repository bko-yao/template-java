package com.start.templatejava.MockBuilder;

import com.start.templatejava.dto.auth.ServiceAccountDTO;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceAccountDtoMockBuilder {
    private long id;
    private String email;
    private String password;
    private String phoneNumber;
    private String firstConnexionDate;
    private String lastConnexionDate;
    private boolean loginWithPhoneNumber;
    private boolean loginWithEmail;
    private boolean asset;
    private String accountStatus;
    private Set<String> roles;

    public ServiceAccountDtoMockBuilder() {
    }

    public ServiceAccountDTO build() {
        ServiceAccountDTO mock = mock(ServiceAccountDTO.class);
        when(mock.getId()).thenReturn(id);
        when(mock.getEmail()).thenReturn(email);
        when(mock.getPhoneNumber()).thenReturn(phoneNumber);
        when(mock.getPassword()).thenReturn(password);
        when(mock.getRoles()).thenReturn(roles);
        return mock;
    }

    public ServiceAccountDtoMockBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public ServiceAccountDtoMockBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ServiceAccountDtoMockBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public ServiceAccountDtoMockBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ServiceAccountDtoMockBuilder setRoles(Set<String> roles) {
        this.roles = roles;
        return this;
    }
}
