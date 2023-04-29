package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "laboratory")
@Getter
@Setter
public class Laboratory extends AbstractEntity {

    @Column(name = "laboratory_name", nullable = false, unique = true)
    private String laboratoryName;
}
