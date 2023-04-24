package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCategory extends AbstractEntity {
    @Column(nullable = false, unique = true)
    private String name;
}