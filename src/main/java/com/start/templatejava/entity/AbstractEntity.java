package com.start.templatejava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.start.templatejava.helper.SecurityHelper;
import com.start.templatejava.security.services.UserDetailsImpl;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/*
 * Pour generaliser les attributs qui sont communs à toutes les entités
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @CreatedBy
    @Column(name = "audit_create_by", nullable = false, updatable = false)
    private String auditCreateBy;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "audit_update_by")
    private String auditUpdateBy;

    @JsonIgnore
    @CreatedDate
    @Column(name = "audit_create_at", nullable = false, updatable = false)
    private LocalDateTime auditCreateAt;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "audit_update_at")
    private LocalDateTime auditUpdateAt;

    /**
     * Version permet de définir le nombre de fois où l'occurrence a été modifiée.
     * La valeur s'incrémente à chaque modification.
     */
    @Version
    @Column(name = "version")
    private int version;

    /**
     * Méthode exécuter avant chaque modification.
     */
    @PreUpdate
    public void onUpdate() {
        UserDetailsImpl userDetails = SecurityHelper.getPrincipal();
        auditUpdateBy = userDetails != null ? userDetails.getEmail() : "system";
        auditUpdateAt = LocalDateTime.now();
    }

    /**
     * Méthode exécuter avant chaque enregistrement.
     */
    @PrePersist
    public void onSave() {
        UserDetailsImpl userDetails = SecurityHelper.getPrincipal();
        auditCreateBy = userDetails != null ? userDetails.getEmail() : "system";
        auditCreateAt = LocalDateTime.now();
    }
}
