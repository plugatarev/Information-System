package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
public class Laboratory extends AbstractEntity {

    @Column(name = "laboratory_name", nullable = false, unique = true)
    private String laboratoryName;
}
