package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_test")
@Getter
@Setter
public class OrderTest extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "laboratory_order", referencedColumnName = "id")
    private LaboratoryOrder laboratoryOrder;

    @ManyToOne
    @JoinColumn(name = "test", referencedColumnName = "id")
    private Test test;
}