package com.github.plugatarev.database.informationsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeCategory extends AbstractEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}