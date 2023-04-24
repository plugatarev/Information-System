package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductStatus extends AbstractEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}