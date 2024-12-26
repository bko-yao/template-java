package com.start.templatejava.entity;

import com.start.templatejava.enumeration.ERole;
import com.start.templatejava.util.Constant;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Entité Role.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Role.TABLE_NAME)
public class Role extends AbstractEntity {

    public static final String TABLE_NAME = "role";
    public static final String TABLE_ID = Constant.PREFIX_ID + TABLE_NAME;

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private ERole designation;
}
