package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "department")
@Getter
@Setter
public class Department extends AbstractEntity {

    @Column(name = "department_name", nullable = false, unique = true)
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "department_chief")
    private Employee departmentChief;
}