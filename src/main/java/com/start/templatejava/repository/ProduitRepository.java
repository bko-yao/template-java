package com.start.templatejava.repository;

import com.start.templatejava.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository de Produit.
 */
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
