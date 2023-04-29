package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "worker_brigade")
@Getter
@Setter
public class WorkerBrigade extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "worker", nullable = false)
    private Employee worker;

    @ManyToOne
    @JoinColumn(name = "brigade", nullable = false)
    private Brigade brigade;
}