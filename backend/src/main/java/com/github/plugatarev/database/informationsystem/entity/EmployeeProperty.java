package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_property")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeProperty extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute")
    private EmployeeTypeAttribute attribute;

    @Column(name = "value")
    private String value;
}