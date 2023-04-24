package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "laboratory_order")
@AllArgsConstructor
@NoArgsConstructor
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