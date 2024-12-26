package com.start.templatejava.MockBuilder;

import com.start.templatejava.entity.Role;
import com.start.templatejava.entity.ServiceAccount;

import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceAccountMockBuilder {
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
    private Set<Role> roles;

    public ServiceAccountMockBuilder() {
    }

    public ServiceAccount build() {
        ServiceAccount mock = mock(ServiceAccount.class);
        when(mock.getId()).thenReturn(id);
        when(mock.getEmail()).thenReturn(email);
        when(mock.getPhoneNumber()).thenReturn(phoneNumber);
        when(mock.getPassword()).thenReturn(password);
        return mock;
    }

    public ServiceAccountMockBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public ServiceAccountMockBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ServiceAccountMockBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public ServiceAccountMockBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
