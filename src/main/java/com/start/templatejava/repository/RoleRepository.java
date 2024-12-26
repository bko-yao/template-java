package com.start.templatejava.repository;

import com.start.templatejava.entity.Role;
import com.start.templatejava.enumeration.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository du Role.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByDesignation(ERole eRole);
}
