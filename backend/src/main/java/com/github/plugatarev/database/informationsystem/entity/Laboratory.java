package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "laboratory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "laboratory_name", nullable = false, unique = true)
    private String laboratoryName;
}
