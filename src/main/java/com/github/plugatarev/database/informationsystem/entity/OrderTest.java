package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_test")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "laboratory_order", referencedColumnName = "id")
    private LaboratoryOrder laboratoryOrder;

    @ManyToOne
    @JoinColumn(name = "test", referencedColumnName = "id")
    private Test test;
}