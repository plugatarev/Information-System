package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "worker_brigade")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerBrigade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "worker", nullable = false)
    private Employee worker;

    @ManyToOne
    @JoinColumn(name = "brigade", nullable = false)
    private Brigade brigade;
}