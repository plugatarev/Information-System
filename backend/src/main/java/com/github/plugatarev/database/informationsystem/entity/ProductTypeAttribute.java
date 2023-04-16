package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_type_attribute")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductTypeAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attribute_name", nullable = false)
    private String attributeName;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    private ProductCategory category;
}