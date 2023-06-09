package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_type", nullable = false)
    private ProductCategoryType categoryType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_department")
    private Department manufacturerDepartment;

    @Column(nullable = false)
    private String customer;
}