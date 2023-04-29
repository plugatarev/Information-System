package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "test")
@Getter
@Setter
public class Test extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "equipment", referencedColumnName = "id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "laboratory_employee", referencedColumnName = "id")
    private Tester tester;

    @Column(name = "description", nullable = false)
    private String description;
}