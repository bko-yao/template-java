package com.start.templatejava.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.start.templatejava.entity.ServiceAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private final long id;

  private String phoneNumber;
  private final String email;
  @JsonIgnore
  private final String password;

  private final Collection<? extends GrantedAuthority> authorities;

  private boolean asset;

  public UserDetailsImpl(long id, String phoneNumber, String email, String password,
                         Collection<? extends GrantedAuthority> authorities, boolean asset) {
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
    this.asset = asset;
  }

  public static UserDetailsImpl build(ServiceAccount serviceAccount) {
    List<GrantedAuthority> authorities = serviceAccount.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.getDesignation().name()))
            .collect(Collectors.toList());

    // Recupérer la personne lié à ce compte de service.
    //ServiceAccount person = serviceAccount.getPerson();

    return new UserDetailsImpl(
            serviceAccount.getId(),
            serviceAccount.getPhoneNumber(),
            serviceAccount.getEmail(),
            serviceAccount.getPassword(),
            authorities,
            serviceAccount.isAsset());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public boolean isAsset() {
    return asset;
  }

  public void setAsset(boolean asset) {
    this.asset = asset;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
