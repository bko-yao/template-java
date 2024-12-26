package com.start.templatejava.service;

import com.start.templatejava.dto.ProduitDTO;
import com.start.templatejava.entity.Categorie;
import com.start.templatejava.entity.Produit;
import com.start.templatejava.exception.CategorieException;
import com.start.templatejava.exception.ProduitException;
import com.start.templatejava.factory.ProductFactory;
import com.start.templatejava.repository.CategorieRepository;
import com.start.templatejava.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service

@AllArgsConstructor
public class ProductService {

    private final CategorieRepository categorieRepository;
    private final ProduitRepository produitRepository;
    private final ProductFactory productFactory;

    /**
     * Crée un produit
     *
     * @param produitDTO Le produit Dto.
     * @return Le statut de la requête.
     */
    @Transactional
    public ResponseEntity<?> creerProduit(ProduitDTO produitDTO) {

        Categorie categorie = this.categorieRepository.findByCode(produitDTO.designationCategorie().toUpperCase().trim())
                .orElseThrow(() -> new CategorieException(
                        "La Catégorie " + produitDTO.designationCategorie().toUpperCase().trim() +
                                " n'existe pas.", NOT_FOUND.value()));

        Produit produit = new Produit(produitDTO.getCode(), produitDTO.getDesignation(), produitDTO.getDescription(),
                produitDTO.getPrix(), produitDTO.getQuantite(), produitDTO.getStatutInventaire(),
                produitDTO.getImage(), produitDTO.getNotatiion(), categorie);

        this.produitRepository.save(produit);

        return ResponseEntity.ok()
                .body("Produit enregistré avec succès.");
    }

    /**
     * Recupère tous les produits.
     *
     * @return Une liste de Produit.
     */
    @Transactional(readOnly = true)
    public Set<ProduitDTO> getAllProducts() {
        List<Produit> produits = this.produitRepository.findAll();
        return this.productFactory.mapProductsToProductDtos(produits);
    }

    /**
     * Recupère un produit par son id
     *
     * @return le produit s'il existe.
     */
    @Transactional
    public ProduitDTO getProductById(long id) {
        Produit produit = this.produitRepository.findById(id)
                .orElseThrow(() -> new ProduitException("Le Produit avec l'id " + id + " n'existe pas.", NOT_FOUND.value()));
        return this.productFactory.mapProductToProductDto(produit);
    }

    /**
     * Modifie le produit s'il existe (Modification partielle).
     *
     * @param id identifiant du produit à modifier
     * @return Le statut de la requête.
     */
    @Transactional
    public ProduitDTO modifieProduit(long id, Map<String, Object> fields) {
        Produit existingProduit = produitRepository.findById(id)
                .orElseThrow(() -> new ProduitException("Le Produit avec l'id " + id + " n'existe pas.", NOT_FOUND.value()));

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Produit.class, key);
            switch (key) {
                case "category" -> {
                    Object finalValue = value.toString();
                    value = this.categorieRepository.findByCode(value.toString().toUpperCase().trim())
                            .orElseThrow(() -> new CategorieException("La Catégorie " + finalValue + " n'existe pas.", NOT_FOUND.value()));
                }
                case "price", "quantity" -> value = Integer.parseInt(value.toString());
                default -> {
                    // TODO Mettre une logique dans le default.
                }
            }
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingProduit, value);
        });
        return this.productFactory.mapProductToProductDto(
                produitRepository.save(existingProduit));
    }

    /**
     * Supprimme le produit.
     *
     * @param id Identifiant du produiot à supprimer.
     */
    @Transactional
    public void deleteProduct(long id) {
        this.produitRepository.deleteById(id);
    }
}
