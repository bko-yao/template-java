package com.start.templatejava.helper;

import com.start.templatejava.entity.Role;
import com.start.templatejava.enumeration.ERole;
import com.start.templatejava.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleHelper {
    private final RoleRepository roleRepository;

    public RoleHelper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Ajouter le rôle de l'utilisateur connecté.
     *
     * @param role Le rôle à ajouter
     * @return Le rôle à ajouter
     */
    public Role addRole(String role) {
        return switch (role.toLowerCase()) {
            case "employee" -> roleRepository.findByDesignation(ERole.EMPLOYEE)
                    .orElseThrow(() -> new RuntimeException("Le Rôle " + ERole.EMPLOYEE.getDesignation() + " n'existe pas."));
            case "client" -> roleRepository.findByDesignation(ERole.CLIENT)
                    .orElseThrow(() -> new RuntimeException("Le Rôle" + ERole.CLIENT.getDesignation() + " n'existe pas."));
            default -> roleRepository.findByDesignation(ERole.ADMIN)
                    .orElseThrow(() -> new RuntimeException("Le Rôle " + ERole.ADMIN.getDesignation() + " n'existe pas."));
        };
    }
}
