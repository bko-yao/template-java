package com.start.templatejava.entity;

import com.start.templatejava.util.Constant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Entité de catégorie.
 */
@Entity
@Table(name = Categorie.TABLE_NAME)
public class Categorie extends AbstractEntity {
    public static final String TABLE_NAME = "category";
    public static final String TABLE_ID = Constant.PREFIX_ID + TABLE_NAME;

    @Column(name = "code", nullable = false, unique = true, updatable = false)
    private String code;
    @Column(name = "designation")
    private String designation;

    /**
     * Constructeur par défaut.
     */
    public Categorie() {
    }

    public String getCode() {
        return code;
    }

    public String getDesignation() {
        return designation;
    }
}
