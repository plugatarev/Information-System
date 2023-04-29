package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_category")
@Getter
@Setter
public class EmployeeCategory extends AbstractEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}