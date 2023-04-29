package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "laboratory_order")
@Getter
@Setter
public class LaboratoryOrder extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "laboratory", referencedColumnName = "id")
    private Laboratory laboratory;
}