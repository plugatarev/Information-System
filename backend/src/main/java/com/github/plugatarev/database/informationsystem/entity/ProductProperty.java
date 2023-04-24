package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_property")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductProperty extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute", nullable = false)
    private ProductTypeAttribute attribute;

    private String value;
}