package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_type_attribute")
@Getter
@Setter
public class EmployeeTypeAttribute extends AbstractEntity {

    @Column(name = "attribute_name", nullable = false)
    private String attributeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_type")
    private EmployeeCategoryType employeeCategoryType;
}