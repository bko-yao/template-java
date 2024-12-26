package com.start.templatejava.repository;


import com.start.templatejava.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository de Category
 */
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Optional<Categorie> findByCode(String code);
}
