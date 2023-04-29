package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_category_type")
@Getter
@Setter
public class ProductCategoryType extends AbstractEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    private ProductCategory category;
}
