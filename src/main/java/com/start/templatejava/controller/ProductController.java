package com.start.templatejava.controller;

import com.start.templatejava.dto.ProduitDTO;
import com.start.templatejava.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Crée un nouveau produit
     *
     * @param produitDTO Le DTO du produit.
     * @return Le statut de la requête.
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> creerProduit(@Valid @RequestBody ProduitDTO produitDTO) {
        return ResponseEntity.ok(productService.creerProduit(produitDTO));
    }

    /**
     * Recupère tous les produits.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<ProduitDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Récupère le produit par son id.
     *
     * @param id Identifiant du produit.
     * @return Le produit s'il existe.
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProduitDTO getAllProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    /**
     * Modifie partiellement un produit.
     *
     * @param id     L'identifiant du produit à modifier
     * @param fields Les champs à modifier
     * @return Le produit modifié.
     */
    @PatchMapping("/{id}")
    public ProduitDTO modifieProduit(@PathVariable int id, @RequestBody Map<String, Object> fields) {
        return productService.modifieProduit(id, fields);
    }

    /**
     * Supprime le produit par son id.
     *
     * @param id Identifiant du produit.
     */
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void supprimeProduit(@PathVariable long id) {
        productService.deleteProduct(id);
    }
}
