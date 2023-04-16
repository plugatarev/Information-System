package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_type", nullable = false)
    private ProductCategoryType categoryType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_department")
    private Department manufacturerDepartment;

    @Column(nullable = false)
    private String customer;
}