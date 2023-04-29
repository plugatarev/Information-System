package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_property")
@Getter
@Setter
public class EmployeeProperty extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "attribute")
    private EmployeeTypeAttribute attribute;

    @Column(name = "value")
    private String value;
}