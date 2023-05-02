package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "order_test")
@Getter
@Setter
public class OrderTest extends AbstractEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laboratory_order", referencedColumnName = "id")
    private LaboratoryOrder laboratoryOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test", referencedColumnName = "id")
    private Test test;

    @Column(name = "testing_date")
    private LocalDate testingDate;
}