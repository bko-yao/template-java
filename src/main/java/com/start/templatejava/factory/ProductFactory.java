package com.start.templatejava.factory;

import com.start.templatejava.dto.ProduitDTO;
import com.start.templatejava.entity.Produit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductFactory {
    /**
     * Retourne une listes de Product DTO à partir d'une source d'entité Product.
     *
     * @param products LMes sources de produits
     * @return La liste de DTO.
     */
    public Set<ProduitDTO> mapProductsToProductDtos(List<Produit> products) {
        return products.stream()
                .map(ProduitDTO::new)
                .collect(Collectors.toSet());
    }

    /**
     * Retourne un DTO à partir d'une entité source product.
     *
     * @param product La source.
     * @return Le DTO
     */
    public ProduitDTO mapProductToProductDto(Produit product) {
        return new ProduitDTO(product);
    }

}
