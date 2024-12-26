package com.start.templatejava.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entité de Produit
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Produit.TABLE_NAME)
public class Produit extends AbstractEntity {
    public static final String TABLE_NAME = "produit";

    @Column(name = "code")
    private String code;
    @Column(name = "designation")
    private String designation;
    @Column(name = "description")
    private String description;
    @Column(name = "prix")
    private int prix;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "statut_inventaire")
    private String statutInventaire;
    @Column(name = "image")
    private String image;
    @Column(name = "notation")
    private Integer notation;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = Categorie.TABLE_ID)
    private Categorie categorie;
}
