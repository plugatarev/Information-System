package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "laboratory_employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LaboratoryEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "laboratory", referencedColumnName = "id")
    private Laboratory laboratory;
}