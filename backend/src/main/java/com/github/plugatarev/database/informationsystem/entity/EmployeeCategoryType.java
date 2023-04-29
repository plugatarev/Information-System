package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_category_type")
@Getter
@Setter
public class EmployeeCategoryType extends AbstractEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "employee_category")
    private EmployeeCategory employeeCategory;
}