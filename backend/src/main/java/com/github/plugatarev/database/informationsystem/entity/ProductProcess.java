package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "product_process")
@Getter
@Setter
public class ProductProcess extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @Column(name = "description_work", nullable = false)
    private String descriptionWork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collecting_brigade")
    private Brigade collectingBrigade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    private ProductStatus status;

    @Column(name = "release_date")
    private LocalDate releaseDate;
}
