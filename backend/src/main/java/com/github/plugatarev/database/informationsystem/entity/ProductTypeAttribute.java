package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_type_attribute")
@Getter
@Setter
public class ProductTypeAttribute extends AbstractEntity {

    @Column(name = "attribute_name", nullable = false)
    private String attributeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    private ProductCategory category;
}