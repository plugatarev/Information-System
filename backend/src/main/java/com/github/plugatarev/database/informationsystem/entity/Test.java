package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "test")
@AllArgsConstructor
@NoArgsConstructor
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