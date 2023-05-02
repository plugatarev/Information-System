package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "laboratory_employee")
@Getter
@Setter
public class Tester extends Employee {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laboratory")
    private Laboratory laboratory;
}