package com.start.templatejava.entity;

import com.start.templatejava.util.Constant;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Entité des comptes de services.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = ServiceAccount.TABLE_NAME)
public class ServiceAccount extends AbstractEntity {

    public static final String TABLE_NAME = "service_account";
    public static final String TABLE_ID = Constant.PREFIX_ID + TABLE_NAME;
    public static final String SERVICE_ACCOUNT_ROLE = "service_account_role";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phone_number";

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "first_connexion_date")
    private LocalDateTime firstConnexionDate;

    @Column(name = "last_connexion_date")
    private LocalDateTime lastConnexionDate;

    @Column(name = "asset", nullable = false, columnDefinition = "boolean default false")
    private boolean asset;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = ServiceAccount.SERVICE_ACCOUNT_ROLE,
            joinColumns = @JoinColumn(name = ServiceAccount.TABLE_ID),
            inverseJoinColumns = @JoinColumn(name = Role.TABLE_ID))
    private Set<Role> roles;

    /**
     * Enregistre le compte de services.
     *
     * @param roles       Les rôles de l'utilisateurs
     * @param password    Le mot de passe chiffré
     * @param email       L'email de l'utilisateur
     * @param phoneNumber Le numéro de téléphone de l'utilisateur
     */
    public void setRecord(Set<Role> roles, String password, String email, String phoneNumber) {
        this.email = email.toLowerCase().trim();
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.roles = roles;
        this.asset = true;
    }
}
