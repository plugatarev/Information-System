package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "brigadier")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Brigadier {

    @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Employee employee;
}