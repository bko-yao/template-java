package com.start.templatejava.dto;

import com.start.templatejava.entity.Produit;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO de produit
 */
@Getter
@Setter
@NoArgsConstructor
public class ProduitDTO {
    private long id;
    @NotBlank(message = "Le code doit être renseigné")
    private String code;
    @NotBlank
    private String designation;
    @NotBlank
    private String description;
    @Min(0)
    private int prix;
    @Min(0)
    private int quantite;
    @NotBlank
    private String statutInventaire;
    @NotBlank
    private CategorieDTO categorie;
    private String image;
    private Integer notatiion;

    public ProduitDTO(Produit produit) {
        this.id = produit.getId();
        this.code = produit.getCode();
        this.designation = produit.getDesignation();
        this.description = produit.getDescription();
        this.prix = produit.getPrix();
        this.quantite = produit.getQuantite();
        this.statutInventaire = produit.getStatutInventaire();
        this.categorie = new CategorieDTO(produit.getCategorie());
        this.image = produit.getImage();
        this.notatiion = produit.getNotation();
    }

    /**
     * recupère la désignation de la catégorie.
     *
     * @return La désignation de la catégorie
     */
    public String designationCategorie() {
        return this.categorie.getDesignation();
    }
}
