package com.start.templatejava.dto;

import com.start.templatejava.entity.Categorie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO pour toute les classes qui ont que
 * les champs code et designation
 */
@Getter
@Setter
@NoArgsConstructor
public class CategorieDTO extends CodeDesignationDTO {

    public CategorieDTO(Categorie categorie) {
        super(categorie.getCode(), categorie.getDesignation());
    }
}
