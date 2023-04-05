package com.github.plugatarev.database.informationsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "brigade")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Brigade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brigade_name", nullable = false, unique = true)
    private String brigadeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brigadier")
    private Brigadier brigadier;
}