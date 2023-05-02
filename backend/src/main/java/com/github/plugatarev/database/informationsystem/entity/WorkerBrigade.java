package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "worker_brigade")
@Getter
@Setter
public class WorkerBrigade extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker")
    private Employee worker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brigade")
    private Brigade brigade;
}