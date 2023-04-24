package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "product_process")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductProcess extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @Column(name = "description_work", nullable = false)
    private String descriptionWork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_region")
    private DepartmentRegion departmentRegion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    private ProductStatus status;

    @Column(name = "release_date")
    private LocalDate releaseDate;
}
