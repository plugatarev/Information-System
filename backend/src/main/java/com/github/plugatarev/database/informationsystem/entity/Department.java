package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "department")
public class Department extends AbstractEntity {

    @Column(name = "department_name", nullable = false, unique = true)
    @Getter @Setter
    private String departmentName;

    @ManyToOne(targetEntity = DepartmentChief.class)
    @JoinColumn(name = "department_chief")
    @Getter @Setter
    private DepartmentChief departmentChief;
}